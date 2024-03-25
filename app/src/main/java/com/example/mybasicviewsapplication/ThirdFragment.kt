package com.example.mybasicviewsapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.mybasicviewsapplication.databinding.FragmentSecondBinding
import com.example.mybasicviewsapplication.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    val stringList = listOf("First", "Second", "Third", "Fourth")

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }

        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, stringList)
        binding.listView.adapter = arrayAdapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val item = stringList[position]
            Log.v("LISTVIEW","Item clicked: $item")
            val bundle = bundleOf("index" to position)
            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}