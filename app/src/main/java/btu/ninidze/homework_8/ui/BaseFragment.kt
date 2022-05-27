package btu.ninidze.homework_8.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        init()

        return binding.root
    }

    abstract fun init()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}