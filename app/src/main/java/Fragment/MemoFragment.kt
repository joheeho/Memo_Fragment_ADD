package Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.memo_recycleview.MemoActivity
import com.example.memo_recycleview.databinding.MemoFragmentBinding

class MemoFragment: Fragment() {
    private lateinit var viewBinding: MemoFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewBinding = MemoFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(context, MemoActivity::class.java)
            startActivity(intent)
        }
    }
}