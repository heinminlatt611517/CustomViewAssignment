package com.example.customviewassignment.views.components

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator

class ProgressCircle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

//    private val backgroundWidth = 5f
//    private val progressWidth = 10f
//
//    private val backgroundPaint = Paint().apply {
//        color = Color.LTGRAY
//        style = Paint.Style.STROKE
//        strokeWidth = backgroundWidth
//        isAntiAlias = true
//    }
//
//    private val progressPaint = Paint().apply {
//        color = Color.RED
//        style = Paint.Style.STROKE
//        strokeWidth = progressWidth
//        isAntiAlias = true
//    }
//
//    var progress: Float = 0f
//        set(value) {
//            field = value
//            invalidate()
//        }
//
//    private val oval = RectF()
//    private var centerX: Float = 0f
//    private var centerY: Float = 0f
//    private var radius: Float = 0f
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        centerX = w.toFloat() / 2
//        centerY = h.toFloat() / 2
//        radius = w.toFloat() / 2 - progressWidth
//        oval.set(centerX - radius,
//            centerY - radius,
//            centerX + radius,
//            centerY + radius)
//        super.onSizeChanged(w, h, oldw, oldh)
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        canvas?.drawCircle(centerX, centerY, radius, backgroundPaint)
//        canvas?.drawArc(oval, 270f, 360f * progress, false, progressPaint)
//    }
private var mViewWidth = 0
    private var mViewHeight = 0
    private val mStartAngle = -90f
    private var mSweepAngle = 0f
    private val mMaxSweepAngle = 360f
    private var mStrokeWidth = 20
    private val mAnimationDuration = 400
    private val mMaxProgress = 100
    private var mDrawText = true
    private var mRoundedCorners = true
    private var mProgressColor = Color.BLACK
    private var mTextColor = Color.BLACK
    private val mPaint: Paint

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initMeasurments()
        drawOutlineArc(canvas)
        if (mDrawText) {
            drawText(canvas)
        }
    }

    private fun initMeasurments() {
        mViewWidth = width
        mViewHeight = height
    }

    private fun drawOutlineArc(canvas: Canvas) {
        val diameter = Math.min(mViewWidth, mViewHeight)
        val pad = mStrokeWidth / 2.0.toFloat()
        val outerOval = RectF(pad, pad, diameter - pad, diameter - pad)
        mPaint.color = mProgressColor
        mPaint.strokeWidth = mStrokeWidth.toFloat()
        mPaint.isAntiAlias = true
        mPaint.strokeCap = if (mRoundedCorners) Paint.Cap.ROUND else Paint.Cap.BUTT
        mPaint.style = Paint.Style.STROKE
        canvas.drawArc(outerOval, mStartAngle, mSweepAngle, false, mPaint)
    }

    private fun drawText(canvas: Canvas) {
        mPaint.textSize = Math.min(mViewWidth, mViewHeight) / 5f
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.strokeWidth = 0f
        mPaint.color = mTextColor

        // Center text
        val xPos = canvas.width / 2
        val yPos =
            (canvas.height / 2 - (mPaint.descent() + mPaint.ascent()) / 2).toInt()
        canvas.drawText(
            calcProgressFromSweepAngle(mSweepAngle).toString() + "%",
            xPos.toFloat(),
            yPos.toFloat(),
            mPaint
        )
    }

    private fun calcSweepAngleFromProgress(progress: Int): Float {
        return mMaxSweepAngle / mMaxProgress * progress
    }

    private fun calcProgressFromSweepAngle(sweepAngle: Float): Int {
        return (sweepAngle * mMaxProgress / mMaxSweepAngle).toInt()
    }

    fun setProgress(progress: Int) {
        val animator =
            ValueAnimator.ofFloat(mSweepAngle, calcSweepAngleFromProgress(progress))
        animator.interpolator = DecelerateInterpolator()
        animator.duration = mAnimationDuration.toLong()
        animator.addUpdateListener { valueAnimator ->
            mSweepAngle = valueAnimator.animatedValue as Float
            invalidate()
        }
        animator.start()
    }

    fun setProgressColor(color: Int) {
        mProgressColor = color
        invalidate()
    }

    fun setProgressWidth(width: Int) {
        mStrokeWidth = width
        invalidate()
    }

    fun setTextColor(color: Int) {
        mTextColor = color
        invalidate()
    }

    fun showProgressText(show: Boolean) {
        mDrawText = show
        invalidate()
    }

    fun useRoundedCorners(roundedCorners: Boolean) {
        mRoundedCorners = roundedCorners
        invalidate()
    }

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    }

}
