# LibraryAds
# Using
- Thêm thư viện sau vào dự án của mình
```
repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
    
 implementation 'com.github.XuanSang98:LibraryAds:1.0.0'
```
- Để sử dụng bạn dùng đoạn code như sau 
```
AdMod.interstitialAds(this, "adUnitId","adTestDevice",::adsOnClickListener)
```
- adsOnClickListener là 1 function sử lý sự load quảng cáo cũng như click quảng cáo vs tham số 
```
fun adsOnClickListener(interstitialad: InterstitialAd) {}
```
- Chúc các bạn thành công
