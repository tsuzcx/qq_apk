package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;

class MiniLoadingAdManager$1$1
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$1$1(MiniLoadingAdManager.1 param1) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick() {}
  
  public void onAdDismiss(boolean paramBoolean) {}
  
  public void onAdShow(View paramView) {}
  
  public void onPreloadAdReceive(boolean paramBoolean) {}
  
  public void onSelectAdProcessDone(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.this$1.val$onChooseAdEndListener != null))
    {
      this.this$1.val$onChooseAdEndListener.onChooseAdEnd(paramString, paramLong);
      return;
    }
    this.this$1.val$onChooseAdEndListener.onChooseAdEnd(null, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.1.1
 * JD-Core Version:    0.7.0.1
 */