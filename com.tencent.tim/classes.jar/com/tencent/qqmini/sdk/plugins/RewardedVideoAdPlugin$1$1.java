package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RewardedVideoAdPlugin$1$1
  implements AdProxy.IRewardVideoAdListener
{
  RewardedVideoAdPlugin$1$1(RewardedVideoAdPlugin.1 param1) {}
  
  public void onADClick()
  {
    QMLog.i("RewardedVideoAdPlugin", "onADClick, time = " + System.currentTimeMillis());
  }
  
  public void onADClose(String paramString)
  {
    QMLog.i("RewardedVideoAdPlugin", "onADClose,  time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$700(this.this$1.this$0, this.this$1.val$req, paramString);
    ThreadManager.executeOnComputationThreadPool(new RewardedVideoAdPlugin.1.1.1(this, paramString));
    if (RewardedVideoAdPlugin.access$900(this.this$1.this$0) != null) {
      RewardedVideoAdPlugin.access$1000(this.this$1.this$0).performAction(AudioFocusEvent.obtain(1));
    }
    AdFrequencyLimit.setRewardVideoAdShowing(false);
  }
  
  public void onADExpose()
  {
    QMLog.i("RewardedVideoAdPlugin", "onADExpose, time = " + System.currentTimeMillis());
  }
  
  public void onADLoad()
  {
    QMLog.i("RewardedVideoAdPlugin", "onADLoad, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$200(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    this.this$1.val$req.ok();
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
  }
  
  public void onADShow()
  {
    if (RewardedVideoAdPlugin.access$400(this.this$1.this$0) != null) {
      RewardedVideoAdPlugin.access$500(this.this$1.this$0).performAction(AudioFocusEvent.obtain(2));
    }
    QMLog.i("RewardedVideoAdPlugin", "onADShow, time = " + System.currentTimeMillis());
  }
  
  public void onError(int paramInt, String paramString)
  {
    QMLog.i("RewardedVideoAdPlugin", "onError, time = " + System.currentTimeMillis() + ", errCode = " + paramInt + ", errMsg = " + paramString);
    RewardedVideoAdPlugin.access$1100(this.this$1.this$0, this.this$1.val$req, paramInt, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, null);
    paramString = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((paramString != null) && (paramString.isGooglePlayVersion())) {
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_ad_switch", 0) != 1) {
        break label170;
      }
    }
    label170:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt == 0) && (!RewardedVideoAdPlugin.access$1200(this.this$1.this$0)))
      {
        AppBrandTask.runTaskOnUiThread(new RewardedVideoAdPlugin.1.1.2(this));
        RewardedVideoAdPlugin.access$1202(this.this$1.this$0, true);
      }
      return;
    }
  }
  
  public void onReward()
  {
    QMLog.i("RewardedVideoAdPlugin", "onReward, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$602(this.this$1.this$0, true);
  }
  
  public void onVideoCached()
  {
    QMLog.i("RewardedVideoAdPlugin", "onVideoCached, time = " + System.currentTimeMillis());
  }
  
  public void onVideoComplete()
  {
    QMLog.i("RewardedVideoAdPlugin", "onVideoComplete, time = " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */