package com.example.paymeviewpager1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.paymeviewpager1.databinding.FragmentPaymeBinding
import com.example.paymeviewpager1.models.Payme

private const val ARG_PARAM1 = "param1"

class PaymeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Payme? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Payme?
        }
    }

    private val binding by lazy { FragmentPaymeBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.apply {

            param1?.img?.let { img1.setImageResource(it) }
            tvTitle.text = param1?.title
            tvDesc.text = param1?.desc

        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Payme) =
            PaymeFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}