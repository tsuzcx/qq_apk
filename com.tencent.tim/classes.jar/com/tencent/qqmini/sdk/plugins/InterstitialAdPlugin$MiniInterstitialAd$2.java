package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class InterstitialAdPlugin$MiniInterstitialAd$2
  implements AdProxy.InterstitialADLisener
{
  InterstitialAdPlugin$MiniInterstitialAd$2(InterstitialAdPlugin.MiniInterstitialAd paramMiniInterstitialAd, int paramInt1, int paramInt2) {}
  
  public void onDismiss()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onDismiss");
    if (InterstitialAdPlugin.MiniInterstitialAd.access$800(this.this$1) != null)
    {
      JSONObject localJSONObject = InterstitialAdPlugin.MiniInterstitialAd.access$900(this.this$1, this.val$compId, -1);
      InterstitialAdPlugin.MiniInterstitialAd.access$800(this.this$1).evaluateSubscribeJS("onInterstitialAdClose", localJSONObject.toString(), 0);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    QMLog.i("SDK_MiniInterstitialAd", "onError, errCode = " + paramInt + ", errMsg = " + paramString);
    InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, false, "operateInterstitialAd", this.val$compId, paramInt, this.val$callbackId);
    InterstitialAdPlugin.MiniInterstitialAd.access$702(this.this$1, false);
  }
  
  public void onLoad()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onLoad");
    InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, true, "operateInterstitialAd", this.val$compId, 0, this.val$callbackId);
    InterstitialAdPlugin.MiniInterstitialAd.access$702(this.this$1, false);
  }
  
  public void onShow()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd.2
 * JD-Core Version:    0.7.0.1
 */