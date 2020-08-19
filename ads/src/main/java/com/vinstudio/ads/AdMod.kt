package com.vinstudio.ads

import android.app.Activity
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.*

object AdMod {

    private var mInterstitialAd: InterstitialAd? = null

    fun interstitialAds(context: Activity, adUnitId: String,adTestDevice: String, adsClickListener: (InterstitialAd) ->Unit) {
        MobileAds.initialize(context) {}
        val mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = adUnitId
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        val testDeviceIds = Arrays.asList(adTestDevice)
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)
        adsClickListener(mInterstitialAd)
    }
}