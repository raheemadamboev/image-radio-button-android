package xyz.teamgravity.imageradiobuttondemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import xyz.teamgravity.imageradiobutton.GravityImageRadioButton
import xyz.teamgravity.imageradiobuttondemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val paddings =
                insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout() or WindowInsetsCompat.Type.ime())
            view.setPadding(paddings.left, paddings.top, paddings.right, paddings.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

        binding.gravityGroup.setOnCheckedChangeListener { _, radioButton, _, _ ->
            Toast.makeText(this@MainActivity, (radioButton as GravityImageRadioButton).text(), Toast.LENGTH_SHORT).show()
        }
    }
}