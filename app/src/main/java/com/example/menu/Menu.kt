package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.menu.databinding.FragmentMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class Menu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu,container,false)
        val action = MenuDirections.actionMenuToLogin()
        NavHostFragment.findNavController(this).navigate(action)

        binding.btnTutorial.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_menu_to_tutorial)}

        binding.btnPractical.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_menu_to_practical)}



        return binding.root
        }



}
