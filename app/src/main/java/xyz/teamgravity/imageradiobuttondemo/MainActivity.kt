package xyz.teamgravity.imageradiobuttondemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xyz.teamgravity.imageradiobutton.GravityImageRadioButton
import xyz.teamgravity.imageradiobutton.GravityRadioGroup
import xyz.teamgravity.imageradiobuttondemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gravityGroup.setOnCheckedChangeListener { _, radioButton, _, _ ->
            Toast.makeText(this@MainActivity, (radioButton as GravityImageRadioButton).text(), Toast.LENGTH_SHORT).show()
        }

        //binding.androidB.setTextColor(R.color.white)
    }
}