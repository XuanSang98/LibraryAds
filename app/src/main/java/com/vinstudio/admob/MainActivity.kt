package com.vinstudio.admob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import com.vinstudio.ads.AdMod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNext.setOnClickListener {
            AdMod.interstitialAds(this, "ca-app-pub-3940256099942544/1033173712", "", ::adsOnClickListener)
        }
    }

    fun adsOnClickListener(interstitialad: InterstitialAd) {
        interstitialad.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                if (interstitialad.isLoaded) {
                    interstitialad.show()
                }
            }

            override fun onAdClosed() {
                super.onAdClosed()
                startActivity(MainActivity2.getIntent(this@MainActivity))
            }

            override fun onAdFailedToLoad(p0: LoadAdError?) {
                super.onAdFailedToLoad(p0)
                Handler().postDelayed({
                    startActivity(MainActivity2.getIntent(this@MainActivity))
                }, 1000)
            }
        }
    }
}
