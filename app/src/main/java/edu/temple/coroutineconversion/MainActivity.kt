package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class MainActivity : AppCompatActivity() {


    private val cakeImageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    private val currentTextView: TextView by lazy {
        findViewById(R.id.currentTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.revealButton).setOnClickListener{

            //(Refactors to replace Thread code with coroutines)
            CoroutineScope(Dispatchers.Default).launch {
                repeat(100) {
                    withContext(Dispatchers.Main) {
                        currentTextView.text = String.format(Locale.getDefault(), "Current opacity: %d", it)
                        cakeImageView.alpha = it / 100f
                    }
                    delay(40)
                }
            }

        }
    }
}