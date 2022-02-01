package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.content.Context;
import astl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;

public class AdProxyImpl$1
  implements Runnable
{
  AdProxyImpl$1(AdProxyImpl paramAdProxyImpl, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, AdProxy.ICmdListener paramICmdListener) {}
  
  public void run()
  {
    MiniAppAd.StGetAdReq localStGetAdReq = AdUtils.createAdRequest(this.val$context, Long.parseLong(this.val$uin), this.cFM, this.val$appid, this.enW, this.val$adType, this.enX, this.cFN, this.cFO, this.cFP, this.vK, this.cCm, this.val$size);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new astl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */