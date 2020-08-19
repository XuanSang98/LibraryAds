package com.vinstudio.admob

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import com.vinstudio.ads.AdMod
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        buttonBack.setOnClickListener {
            AdMod.interstitialAds(this,"ca-app-pub-3940256099942544/1033173712","",::loadAds)
        }
    }
    fun loadAds(interstitialad: InterstitialAd){
        interstitialad.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                if (interstitialad.isLoaded) {
                    interstitialad.show()
                }
            }

            override fun onAdClosed() {
                super.onAdClosed()
                finish()

            }

            override fun onAdFailedToLoad(p0: LoadAdError?) {
                super.onAdFailedToLoad(p0)
                    finish()
            }
        }
    }
    companion object{
        fun getIntent(context: Context) = Intent(context,MainActivity2::class.java)
    }
}