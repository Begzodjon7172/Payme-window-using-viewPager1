package com.example.paymeviewpager1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.paymeviewpager1.PaymeFragment
import com.example.paymeviewpager1.models.Payme

class PaymeAdapter(var fragmentManager: FragmentManager, var list:ArrayList<Payme>):FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return PaymeFragment.newInstance(list[position])
    }


}