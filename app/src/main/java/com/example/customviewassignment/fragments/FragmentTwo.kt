package com.example.customviewassignment.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.customviewassignment.R
import com.example.customviewassignment.adapter.TaskRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_fragment_one.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentTwo : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mTaskAdapter : TaskRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTaskRecyclerView()
    }

    private fun setUpTaskRecyclerView(){
        mTaskAdapter= TaskRecyclerAdapter()
        val linearLayoutManger = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        rvProfileTask.layoutManager=linearLayoutManger
        rvProfileTask.adapter= mTaskAdapter

        mTaskAdapter.setNewData(mutableListOf(1,2,3,4,5))
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentTwo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
