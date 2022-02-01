package com.tencent.mobileqq.apollo.process.ads;

import abmw;
import abmw.a;
import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$2
  implements Runnable
{
  public CmGameBannerAds$2(abmw paramabmw, int paramInt) {}
  
  public void run()
  {
    try
    {
      abmw.a locala = (abmw.a)abmw.a(this.this$0).get(Integer.valueOf(this.cqc));
      Activity localActivity = abmw.a(this.this$0);
      if ((locala != null) && (locala.AK != null))
      {
        if (localActivity == null) {
          return;
        }
        ((FrameLayout)localActivity.findViewById(2131363281)).removeView(locala.AK);
        abmw.a(this.this$0).remove(Integer.valueOf(this.cqc));
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.2
 * JD-Core Version:    0.7.0.1
 */