package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.menu.databinding.FragmentEditProfileBinding
import kotlinx.android.synthetic.main.fragment_edit_profile.*

/**
 * A simple [Fragment] subclass.
 */
class EditProfile : Fragment() {

    lateinit var handler: AccDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEditProfileBinding>(inflater,
            R.layout.fragment_edit_profile,container,false)

            handler = AccDatabase(binding.root.context)

        var data = handler.retrieveData(GlobalVariable.userID)
        for(i in 0..(data.size-1)){
            binding.editusername.append(data.get(i).username)
            binding.editpass.append(data.get(i).password)
            binding.editemail.append(data.get(i).email)
            binding.editaddress.append(data.get(i).address)
        }

        binding.editButton.setOnClickListener {
            if (binding.editpass.text.toString().isNotEmpty()) {
                if (binding.editpass.text.toString() == binding.editpassword.text.toString()) {
                    if (binding.editemail.text.toString().isNotEmpty() && binding.editaddress.text.toString().isNotEmpty()) {
                        handler.editProfile(editusername.text.toString(), editpass.text.toString(), editemail.text.toString(), editaddress.text.toString())
                        Toast.makeText(activity, "Edit Profile Successful", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(activity, "Email & Address cannot be empty", Toast.LENGTH_SHORT).show()
                    }
                } else
                    Toast.makeText(activity, "Incorrect Confirm Password", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(activity, "Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}
