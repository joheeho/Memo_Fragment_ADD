package Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.memo_recycleview.SettingFragmentVPAdapter
import com.example.memo_recycleview.databinding.SettingFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class SettingFragment: Fragment() {
    private lateinit var viewBinding: SettingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewBinding = SettingFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val SF_VPAdapter = SettingFragmentVPAdapter(requireActivity())
        viewBinding.vpMain.adapter = SF_VPAdapter

        TabLayoutMediator(viewBinding.tabMain,viewBinding.vpMain){ tab , position->
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}