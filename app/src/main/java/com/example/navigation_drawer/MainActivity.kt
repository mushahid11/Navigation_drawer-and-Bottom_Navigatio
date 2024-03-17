package com.example.navigation_drawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = findViewById(R.id.custom_Toolbar)
        val navigationView: NavigationView = findViewById(R.id.navigation_drawer)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation_bottom)


        //to add three lines on toolbar for opening and closing navigation bar
        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.open)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(BlankFragment1())
                R.id.nav_home1 -> replaceFragment(BlankFragment2())
                R.id.nav_home3 -> replaceFragment(BlankFragment3())
                R.id.nav_home4 -> replaceFragment(BlankFragment4())
                R.id.draw_home -> replaceFragment(BlankFragment5())
                R.id.draw_home1 -> replaceFragment(BlankFragment6())

                else -> {
                }
            }
            drawerLayout.close()


             true

        }

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(BlankFragment1())
                R.id.nav_home1 -> replaceFragment(BlankFragment2())
                R.id.nav_home3 -> replaceFragment(BlankFragment3())
                R.id.nav_home4 -> replaceFragment(BlankFragment4())
                R.id.draw_home -> replaceFragment(BlankFragment5())
                R.id.draw_home1 -> replaceFragment(BlankFragment6())

                else -> {
                }
            }
            drawerLayout.close()
            true

        }


    }


    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)


// Optionally, add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }


}