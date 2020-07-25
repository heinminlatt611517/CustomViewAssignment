package com.example.customviewassignment.views.components

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

class ProfileImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {


    private val borderColor = Color.BLACK
    private val borderWidth = 20.0f

    override fun onDraw(canvas: Canvas) {
        drawRoundImage(canvas)
        //drawStroke(canvas)
    }

    private fun drawStroke(canvas: Canvas) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val radius = width / 2f

        /* Border paint */
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas.drawCircle(width / 2f, width / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawRoundImage(canvas: Canvas) {
        var b: Bitmap = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)

        /* Scale the bitmap */
        val scaledBitmap: Bitmap
        val ratio: Float = bitmap.width.toFloat() / bitmap.height.toFloat()
        val height: Int = Math.round(width / ratio)
        scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)

        /* Cutting the outer of the circle */
        val shader: Shader
        shader = BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val rect = RectF()
        rect.set(0f, 0f, width.toFloat(), height.toFloat())

        val imagePaint = Paint()
        imagePaint.isAntiAlias = true
        imagePaint.shader = shader
        canvas.drawRoundRect(rect, width.toFloat(), height.toFloat(), imagePaint)
    }

//    private var borderColor = Color.BLACK
//    private val path = Path()
//    private var borderWidth = 5.0f
//    private var cornerRadius = 160f
//
//    private var size=50f
//
//    override fun onDraw(canvas: Canvas?) {
//
//        canvas?.let { drawStroke(it) }
//
//        super.onDraw(canvas)
//
//    }
//
//    private fun drawStroke(canvas: Canvas) {
//        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//        val radius = size / 2f
//
//        val rectangle = RectF(0f,0f,width.toFloat(),height.toFloat())
//        /* Border paint */
//        paint.color = borderColor
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = borderWidth
//        //canvas.drawCircle(width / 2f, width / 2f, radius - borderWidth / 2f, paint)
//        canvas?.drawCircle(size/2f,size/2f,radius - borderWidth/2f,paint)
//    }
//
//    private fun drawCircleImage(canvas: Canvas){
//        val rectangle = RectF(0f,0f,width.toFloat(),height.toFloat())
//
//        path.addRoundRect(rectangle,cornerRadius,cornerRadius,Path.Direction.CCW)
//
//        canvas?.clipPath(path)
//    }

}