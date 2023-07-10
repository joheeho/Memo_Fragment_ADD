package com.example.memo_recycleview

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memo_recycleview.databinding.HomeFragmentBinding
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class HomeFragment : Fragment() {
    private lateinit var viewBinding: HomeFragmentBinding
    private lateinit var adapter: DataAdapter
    private lateinit var getText: ActivityResultLauncher<Intent>
    private var dataList: ArrayList<Data> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DataAdapter(dataList) // 어댑터 초기화
        viewBinding.rvData.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.rvData.adapter = adapter

        getText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val mString = result.data?.getStringExtra("data")
                if (mString != null) {
                    dataList.add(Data(mString))
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
