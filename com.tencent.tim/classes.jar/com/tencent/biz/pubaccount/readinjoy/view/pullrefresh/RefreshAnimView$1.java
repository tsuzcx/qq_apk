package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import nqd;

public class RefreshAnimView$1
  implements Runnable
{
  RefreshAnimView$1(RefreshAnimView paramRefreshAnimView, Context paramContext) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.val$context, "readinjoy_refresh_animation.json", new nqd(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RefreshAnimView", 2, "fromAssetFileName", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.1
 * JD-Core Version:    0.7.0.1
 */