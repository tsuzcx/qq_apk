package com.tencent.gdtad.api.interstitial;

import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import org.json.JSONObject;
import thi;
import tho;
import tkv;
import tkw;

public final class GdtInterstitialNotifyReg$1
  implements Runnable
{
  public GdtInterstitialNotifyReg$1(GdtInterstitialParams paramGdtInterstitialParams, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.c != null) {
          continue;
        }
        ark.arkNotify(tho.a().a().appName, this.aJq, localJSONObject1.toString(), "json");
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        JSONObject localJSONObject2;
        tkw.e("GdtInterstitialNotifyReg", "sendEvent", localThrowable);
        continue;
      }
      tkw.i("GdtInterstitialNotifyReg", String.format("sendEvent %s", new Object[] { this.aJq }));
      return;
      if (this.c.iD())
      {
        localObject = tkv.pbToJson(this.c.a.ad.info);
        if ((localObject != null) && (localObject != JSONObject.NULL))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("adInfo", localObject);
          localJSONObject1.put("gdt", localJSONObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1
 * JD-Core Version:    0.7.0.1
 */