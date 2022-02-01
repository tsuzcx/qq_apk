package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import anpc;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import wgv;

public final class WebAccelerator$1
  implements Runnable
{
  public WebAccelerator$1(String paramString, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    Object localObject1 = this.Iq;
    Object localObject2 = wgv.a();
    int i;
    if (wgv.hy(this.Iq))
    {
      localObject1 = ((wgv)localObject2).hl(this.Iq);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.M.putExtra("url", (String)localObject1);
        i = 1;
      }
    }
    for (;;)
    {
      if ((!wgv.aI(this.I)) && (((wgv)localObject2).hw((String)localObject1))) {
        this.M.putExtra("key_isReadModeEnabled", false);
      }
      for (int j = 1;; j = 0)
      {
        localObject1 = (Long)wgv.a((wgv)localObject2).remove(this.Iq);
        if ((localObject1 != null) && (SystemClock.uptimeMillis() - ((Long)localObject1).longValue() < 180000L))
        {
          ((wgv)localObject2).xf("bank_download_key");
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("count", "1");
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOWebPreDownloadHit", false, 0L, 0L, (HashMap)localObject1, "", false);
        }
        if ((j != 0) || (i != 0))
        {
          ((wgv)localObject2).xf("bankSize");
          localObject1 = wgv.a().j();
          localObject2 = ((SharedPreferences)localObject1).edit();
          if (i != 0) {
            ((SharedPreferences.Editor)localObject2).putInt("hit_shortLink", ((SharedPreferences)localObject1).getInt("hit_shortLink", 0) + 1);
          }
          if (j != 0) {
            ((SharedPreferences.Editor)localObject2).putInt("hit_safeCheck", ((SharedPreferences)localObject1).getInt("hit_safeCheck", 0) + 1);
          }
          ((SharedPreferences.Editor)localObject2).commit();
        }
        if (!wgv.d(this.I, this.Iq, this.M)) {
          this.I.startActivity(this.M);
        }
        return;
        localObject1 = this.Iq;
        i = 0;
        break;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.WebAccelerator.1
 * JD-Core Version:    0.7.0.1
 */