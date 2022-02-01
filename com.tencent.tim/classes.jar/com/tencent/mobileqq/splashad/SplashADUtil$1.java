package com.tencent.mobileqq.splashad;

import android.text.TextUtils;
import aqgz;
import arwv;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

public final class SplashADUtil$1
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if ((this.dKc == 0) || (TextUtils.isEmpty(this.ceK)))
        {
          if (!QLog.isColorLevel()) {
            break label386;
          }
          QLog.w("SplashAD", 2, "exporsure failed , adEntry not ready");
          return;
        }
        i = this.dKc;
        localObject3 = this.ceK;
        localObject1 = localObject3;
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        int i;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label386;
        }
        QLog.w("SplashAD", 2, localException.toString());
        return;
        localObject2 = localObject3;
        if (!((String)localObject3).contains("[timestamp]")) {
          continue;
        }
        localObject2 = ((String)localObject3).replace("[timestamp]", System.currentTimeMillis() + "");
        continue;
        localObject2 = localObject3;
        if (!((String)localObject3).contains("__APP__")) {
          continue;
        }
        localObject2 = ((String)localObject3).replace("__APP__", arwv.encodeHexStr("android_qq_splash"));
        localObject3 = aqgz.getIMEI();
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        arwv.encodeHexStr((String)localObject3);
        localObject3 = localObject2;
        if (!((String)localObject2).contains("__OS__")) {
          continue;
        }
        localObject3 = ((String)localObject2).replace("__OS__", "0");
        localObject2 = localObject3;
        if (!((String)localObject3).contains("__IMEI__")) {
          continue;
        }
        localObject2 = localObject3;
        if (TextUtils.isEmpty("")) {
          continue;
        }
        localObject2 = ((String)localObject3).replace("__IMEI__", "");
        continue;
        boolean bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SplashAD", 2, "exporsure platform = " + i + ", url :" + ((String)localObject1).toString());
      }
      localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      ((HttpURLConnection)localObject1).setConnectTimeout(10000);
      ((HttpURLConnection)localObject1).setReadTimeout(10000);
      ((HttpURLConnection)localObject1).setUseCaches(false);
      ((HttpURLConnection)localObject1).connect();
      i = ((HttpURLConnection)localObject1).getResponseCode();
      if (i == 200)
      {
        bool = true;
        if (!QLog.isColorLevel()) {
          break label386;
        }
        QLog.i("SplashAD", 1, "exporsure rspCode " + i + "， request thirdparty" + bool);
      }
      label386:
      return;
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADUtil.1
 * JD-Core Version:    0.7.0.1
 */