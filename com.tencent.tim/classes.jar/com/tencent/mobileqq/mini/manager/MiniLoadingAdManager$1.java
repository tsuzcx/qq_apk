package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;

class MiniLoadingAdManager$1
  implements Runnable
{
  MiniLoadingAdManager$1(MiniLoadingAdManager paramMiniLoadingAdManager, MiniAppConfig paramMiniAppConfig, String paramString, MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener) {}
  
  public void run()
  {
    MiniAppAd.StGetAdReq localStGetAdReq = MiniLoadingAdManager.access$000(this.val$miniAppConfig, this.val$uin, 0);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new MiniLoadingAdManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.1
 * JD-Core Version:    0.7.0.1
 */