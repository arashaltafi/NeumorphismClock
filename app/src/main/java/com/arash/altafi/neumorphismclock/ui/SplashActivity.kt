package com.arash.altafi.neumorphismclock.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.arash.altafi.neumorphismclock.BuildConfig
import com.arash.altafi.neumorphismclock.R
import com.arash.altafi.neumorphismclock.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    private val shakeAnimation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.shake)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        tvAppVersion.text = BuildConfig.VERSION_NAME

        tvClock.startAnimation(shakeAnimation)


        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.tvClock.clearAnimation()
    }

}