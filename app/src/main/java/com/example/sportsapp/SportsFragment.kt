package com.example.sportsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sportsapp.databinding.FragmentSportsBinding

class SportsFragment : Fragment(R.layout.fragment_sports) {
    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!
    private  val baseballFragment = BaseballFragment()
    private  val basketballFragment = BasketballFragment()
    private  val soccerFragment = SoccerFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sportsNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.baseball -> setCurrentFragment(baseballFragment)
                R.id.basketball -> setCurrentFragment(basketballFragment)
                R.id.Soccer -> setCurrentFragment(soccerFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}