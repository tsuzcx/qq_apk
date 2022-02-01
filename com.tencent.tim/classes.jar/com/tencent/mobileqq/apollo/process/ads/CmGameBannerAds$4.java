package com.tencent.mobileqq.apollo.process.ads;

import abmt;
import abmw;
import abmx;
import abos;
import abql;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import thd;
import thf;
import tls;

public class CmGameBannerAds$4
  implements Runnable
{
  public CmGameBannerAds$4(abmw paramabmw, int paramInt1, long paramLong, int paramInt2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = abmw.a(this.this$0, this.val$viewId);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("cmgame_process.CmGameBannerAds", 2, "[loadBannerAd], cannot find posId.");
        abmw.a(this.this$0, this.Od, this.cqc, -2, -2);
        return;
      }
      CmGameInitParams localCmGameInitParams = abmw.a(this.this$0);
      if (localCmGameInitParams != null)
      {
        Object localObject2 = abmt.a(abmw.a(this.this$0));
        if (localObject2 != null)
        {
          localObject2 = ((abos)localObject2).a();
          if (localObject2 != null)
          {
            thd localthd = new thd();
            localthd.b = abmw.b(Long.parseLong(abmt.getAppInterface().getCurrentAccountUin()), (String)localObject1, localCmGameInitParams.adDevUin, abmw.a(this.this$0), localCmGameInitParams.mSrc, localCmGameInitParams.adShareRate);
            localthd.c = ((abql)localObject2).a(null);
            localthd.style = 0;
            int i = tls.b(abmw.a(this.this$0), 1080, 1026);
            int j = thf.ad(localthd.style, i);
            localthd.width = i;
            localthd.height = j;
            localObject1 = new GdtBannerAd(localthd);
            ((GdtBannerAd)localObject1).setListener(new WeakReference(new abmx(this, (GdtBannerAd)localObject1)));
            ((GdtBannerAd)localObject1).load(abmw.a(this.this$0));
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      abmw.a(this.this$0, this.Od, this.cqc, -100, -1);
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.4
 * JD-Core Version:    0.7.0.1
 */