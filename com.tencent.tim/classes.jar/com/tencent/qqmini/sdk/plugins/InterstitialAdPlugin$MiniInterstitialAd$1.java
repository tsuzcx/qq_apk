package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class InterstitialAdPlugin$MiniInterstitialAd$1
  implements Runnable
{
  InterstitialAdPlugin$MiniInterstitialAd$1(InterstitialAdPlugin.MiniInterstitialAd paramMiniInterstitialAd, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (InterstitialAdPlugin.MiniInterstitialAd.access$000(this.this$1) != null)
        {
          Activity localActivity = (Activity)InterstitialAdPlugin.MiniInterstitialAd.access$000(this.this$1).get();
          if ((localActivity != null) && (InterstitialAdPlugin.MiniInterstitialAd.access$100(this.this$1).show(localActivity)))
          {
            InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, true, "operateInterstitialAd", this.val$compId, 0, this.val$callbackId);
            ActivityResultManager.g().addActivityResultListener(new InterstitialAdPlugin.MiniInterstitialAd.1.1(this));
            AdFrequencyLimit.setInterstitialAdShowing(true);
            return;
          }
          QMLog.e("SDK_MiniInterstitialAd", "activity is null");
          InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("SDK_MiniInterstitialAd", "adInterstitial show Exception:", localThrowable);
        InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
        return;
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd.1
 * JD-Core Version:    0.7.0.1
 */