package com.example.memo_recycleview

import Fragment.MemoFragment
import Fragment.SettingFragment
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memo_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerFragment.id, MemoFragment())
            .commitAllowingStateLoss()

        binding.navBottom.run {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_memo-> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, MemoFragment())
                            .commitAllowingStateLoss()

                    }
                    R.id.menu_home-> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting-> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
                }
            selectedItemId = R.id.menu_memo
            }
        }


    }