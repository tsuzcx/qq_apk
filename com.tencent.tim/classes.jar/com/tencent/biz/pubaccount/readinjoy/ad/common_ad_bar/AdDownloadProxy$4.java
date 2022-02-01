package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import kjt;

public class AdDownloadProxy$4
  implements Runnable
{
  public AdDownloadProxy$4(kjt paramkjt, int paramInt1, int paramInt2, NativeAdDownloadView paramNativeAdDownloadView, TextView paramTextView) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      this.this$0.b.mState = this.val$state;
      this.this$0.b.aTP = this.val$progress;
    }
    switch (this.val$state)
    {
    case 2: 
    case 7: 
    default: 
    case 3: 
    case 5: 
    case 1: 
    case 4: 
    case 6: 
      do
      {
        return;
        this.a.ck(this.val$state, this.val$progress);
        this.oc.setVisibility(8);
        this.a.setVisibility(0);
        return;
        this.oc.setVisibility(0);
        this.a.ck(this.val$state, this.val$progress);
        this.a.setVisibility(8);
        this.this$0.ph(this.val$state);
        return;
        this.oc.setVisibility(0);
        this.a.ck(this.val$state, this.val$progress);
        this.a.setVisibility(8);
        return;
        this.oc.setVisibility(8);
        this.a.setVisibility(0);
        this.a.ck(this.val$state, this.val$progress);
        return;
        this.oc.setVisibility(0);
        this.a.setVisibility(8);
      } while (this.this$0.context == null);
      return;
    }
    this.this$0.aDI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.4
 * JD-Core Version:    0.7.0.1
 */