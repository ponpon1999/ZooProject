package com.example.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.animal.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var InfoData3: String? = null
    private var Pic_url: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val binding = FragmentThirdBinding.bind(view)
        binding.AlsoKnown.setText(InfoData3)
        binding.pic3.load(Pic_url.toString().replace("http", "https"))
        return view
    }

    companion object {
        fun newInstance(alsoKnown: String,pic_url: String) =
            ThirdFragment().apply {
                InfoData3 = alsoKnown
                Pic_url = pic_url
            }
    }
}