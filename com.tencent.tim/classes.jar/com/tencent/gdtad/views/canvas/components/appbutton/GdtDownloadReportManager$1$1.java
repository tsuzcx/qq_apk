package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import tkw;
import tlg;
import tlu;
import tlv;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(tlv paramtlv, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = tlu.a(tlu.a());
    if (localObject == null)
    {
      tkw.e("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      tlg.a(tlu.a(this.a.b), 284);
    }
    for (;;)
    {
      tlu.a(this.a.b, this.val$appId);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        tkw.i("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        tlg.a(tlu.a(this.a.b), 284);
      }
      else if (((String)localObject).equals(this.aJz))
      {
        tkw.i("GdtDownloadReportManager", "fetch sigh MD5 matched");
        tlg.a(tlu.a(this.a.b), 275);
      }
      else
      {
        tkw.i("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        tlg.a(tlu.a(this.a.b), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */