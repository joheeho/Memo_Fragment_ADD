package com.example.memo_recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memo_recycleview.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.storebutton.setOnClickListener {
            val data = viewBinding.editText.text.toString()
            val intent = Intent(this,HomeFragment::class.java)
            intent.putExtra("data",data)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}
