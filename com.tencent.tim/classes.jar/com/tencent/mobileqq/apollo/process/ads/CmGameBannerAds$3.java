package com.tencent.mobileqq.apollo.process.ads;

import abmw;
import abmw.a;
import android.app.Activity;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameBannerAds$3
  implements Runnable
{
  public CmGameBannerAds$3(abmw paramabmw, int paramInt) {}
  
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
        locala.AK.setVisibility(8);
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.3
 * JD-Core Version:    0.7.0.1
 */