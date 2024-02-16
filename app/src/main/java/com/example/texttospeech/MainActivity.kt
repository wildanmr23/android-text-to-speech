package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.texttospeech.databinding.ActivityMainBinding
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var tts: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnClick.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS) {

                    tts.language = Locale.US
                    tts.speak(binding.editText.text.toString(), TextToSpeech.QUEUE_ADD, null)
                }
            })
        }
    }
}