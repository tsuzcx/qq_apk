package com.tencent.biz.subscribe;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;
import ram;

public final class SubscribeUtils$2
  implements Runnable
{
  public SubscribeUtils$2(String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.aot)) {
        return;
      }
      localURL = new URL(this.aot);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.connect();
      i = localHttpURLConnection.getResponseCode();
      if (i != 200) {
        break label176;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        URL localURL;
        int i;
        ram.i("SubscribeUtils", "report exception" + localException.toString());
        if (!QZLog.isColorLevel()) {
          break;
        }
        QZLog.w("SubscribeUtils", 2, new Object[] { localException.toString() });
        return;
        label176:
        boolean bool = false;
      }
    }
    ram.i("SubscribeUtils", "report rspCode " + i + "， request thirdparty" + bool + " url =" + localURL);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.2
 * JD-Core Version:    0.7.0.1
 */