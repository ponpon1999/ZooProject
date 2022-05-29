package com.example.animal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.bumptech.glide.Glide
import com.example.animal.databinding.FragmentThirdBinding
import kotlinx.android.synthetic.main.fragment_third.*


class ThirdFragment : Fragment() {
    private var AlsoKnown: String? = null
    private var Pic_url: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val binding = FragmentThirdBinding.bind(view)
        binding.AlsoKnown.setText(AlsoKnown)
        binding.pic3.load(Pic_url)
        return view
    }

    companion object {
        fun newInstance(alsoKnown: String,pic_url: String) =
            ThirdFragment().apply {
                AlsoKnown = alsoKnown
                Pic_url = pic_url
            }
    }

}