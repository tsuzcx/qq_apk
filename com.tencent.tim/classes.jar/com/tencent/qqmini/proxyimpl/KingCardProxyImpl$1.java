package com.tencent.qqmini.proxyimpl;

import acbn;
import android.app.Activity;
import aqvv;
import asuo;
import asup;
import awig;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class KingCardProxyImpl$1
  implements Runnable
{
  public KingCardProxyImpl$1(asuo paramasuo, Activity paramActivity, DiniFlyAnimationView paramDiniFlyAnimationView, IMiniAppContext paramIMiniAppContext) {}
  
  public void run()
  {
    if (!asuo.a(this.this$0))
    {
      awig.a().a(this.val$activity, this.n, asuo.a(this.this$0), 1, 14.0F, 5.0D, 10.0D, 3000L, -16578534, false, true, 0, null, 0);
      asuo.a(this.this$0);
    }
    for (;;)
    {
      this.n.addAnimatorListener(new asup(this));
      if (!this.val$miniAppContext.isMiniGame()) {
        break;
      }
      asuo.a(this.this$0).a(this.n, MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE, acbn.bnc + MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE.hashCode() + ".zip", true);
      return;
      QLog.i("KingCardProxyImpl", 1, "showKingCardTips, guide had been showed, not show this time");
    }
    asuo.a(this.this$0).a(this.n, MiniAppGlobal.KINGCARD_GUIDE_LOTTIE, acbn.bnc + MiniAppGlobal.KINGCARD_GUIDE_LOTTIE.hashCode() + ".zip", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */