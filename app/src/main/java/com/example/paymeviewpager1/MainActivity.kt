package com.example.paymeviewpager1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.paymeviewpager1.adapters.PaymeAdapter
import com.example.paymeviewpager1.databinding.ActivityMainBinding
import com.example.paymeviewpager1.models.Payme
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<Payme>
    private lateinit var paymeAdapter: PaymeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()
        paymeAdapter = PaymeAdapter(supportFragmentManager, list)
        binding.viewPager.adapter = paymeAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.apply {

            tv1.setOnClickListener {
                Toast.makeText(this@MainActivity, "Boshqa oynaga o'tiladi", Toast.LENGTH_SHORT)
                    .show()
            }

            tv2.setOnClickListener {
                if (tabLayout.selectedTabPosition != tabLayout.tabCount - 1) {
                    viewPager.setCurrentItem(tabLayout.selectedTabPosition + 1, true)
                } else {
                    viewPager.setCurrentItem(0, true)
                }
            }

            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tabLayout.selectedTabPosition == tabLayout.tabCount - 1) {
                        tv2.visibility = View.INVISIBLE
                    } else {
                        tv2.visibility = View.VISIBLE
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })

        }


    }

    private fun loadData() {
        list = ArrayList()
        list.add(
            Payme(
                R.drawable.img1,
                "Click va Paymega o’tish xizmati",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        list.add(
            Payme(
                R.drawable.img2,
                "Barcha operatorlar bo’yicha statistika",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        list.add(
            Payme(
                R.drawable.img3,
                "Tariflarni filtrlash",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
        list.add(
            Payme(
                R.drawable.img4,
                "Yangi imkoniyatlar",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
            )
        )
    }
}