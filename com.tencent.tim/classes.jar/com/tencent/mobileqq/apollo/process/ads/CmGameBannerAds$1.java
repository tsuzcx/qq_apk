package com.tencent.mobileqq.apollo.process.ads;

import abmw;
import abmw.a;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$1
  implements Runnable
{
  public CmGameBannerAds$1(abmw paramabmw, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    try
    {
      Object localObject = (abmw.a)abmw.a(this.this$0).get(Integer.valueOf(this.cqc));
      Activity localActivity = abmw.a(this.this$0);
      if ((localObject != null) && (((abmw.a)localObject).AK != null))
      {
        if (localActivity == null) {
          return;
        }
        localObject = (RelativeLayout.LayoutParams)((abmw.a)localObject).AK.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = this.mQ;
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.dS;
        ((RelativeLayout.LayoutParams)localObject).width = this.val$w;
        ((RelativeLayout.LayoutParams)localObject).height = this.val$h;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.1
 * JD-Core Version:    0.7.0.1
 */