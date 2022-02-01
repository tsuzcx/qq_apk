package com.tencent.mobileqq.apollo.process.ads;

import abmt;
import abmw;
import abmw.a;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;
import the;
import tls;

public class CmGameBannerAds$5
  implements Runnable
{
  public CmGameBannerAds$5(abmw paramabmw, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    try
    {
      localObject1 = abmw.a(this.this$0);
      if (localObject1 == null) {
        return;
      }
      abmw.a locala = (abmw.a)abmw.a(this.this$0).get(Integer.valueOf(this.cqc));
      if (locala == null) {
        return;
      }
      if (locala.AK != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameBannerAds", 2, "banner view exists, show it.");
        }
        locala.AK.setVisibility(0);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable1, new Object[0]);
      return;
    }
    Object localObject2 = localThrowable1.d;
    if ((localObject2 != null) && (((GdtBannerAd)localObject2).isLoaded()) && (!((GdtBannerAd)localObject2).isInvalidated()))
    {
      int i = tls.b(abmw.a(this.this$0), 1080, 1026);
      int j = tls.b(abmw.a(this.this$0), 1080, 249);
      localObject2 = ((GdtBannerAd)localObject2).render((Context)localObject1, i, j);
      if ((localObject2 != null) && (((the)localObject2).getView() != null))
      {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
        int k = abmw.b(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "screenH:", Integer.valueOf(k) });
        }
        if (k <= 0)
        {
          QLog.i("cmgame_process.CmGameBannerAds", 1, "view height isn't correct.");
          return;
        }
        localLayoutParams.topMargin = (k - this.dS - j);
        localLayoutParams.leftMargin = this.mQ;
        localObject1 = (FrameLayout)((Activity)localObject1).findViewById(2131363281);
        if (localObject1 != null)
        {
          ((FrameLayout)localObject1).addView(((the)localObject2).getView(), localLayoutParams);
          localThrowable1.AK = ((the)localObject2).getView();
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("bannerId", this.cqc);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("x", this.mQ);
          ((JSONObject)localObject1).put("y", this.dS);
          ((JSONObject)localObject1).put("w", i);
          ((JSONObject)localObject1).put("h", j);
          localJSONObject.put("style", localObject1);
          abmt.a().callbackFromRequest(this.Od, 0, "sc.game_ad_banner_show.local", localJSONObject.toString());
          return;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.5
 * JD-Core Version:    0.7.0.1
 */