package com.example.sportsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sportsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = binding.myToolbar

        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val profileFragment = ProfileFragment()
        val sportsFragment = SportsFragment()

        setCurrentFragment(homeFragment)
        val bottomNav = binding.bottomNavigationView

        actionBar.title = "Home"

        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miAccount -> setCurrentFragment(accountFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
                R.id.miSports -> setCurrentFragment(sportsFragment)
            }
            actionBar.title = it.title
            true
        }
        bottomNav.getOrCreateBadge(R.id.miProfile).apply {
            number = 10
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}