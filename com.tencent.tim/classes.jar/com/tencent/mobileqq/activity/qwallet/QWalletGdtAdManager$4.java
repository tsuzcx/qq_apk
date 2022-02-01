package com.tencent.mobileqq.activity.qwallet;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import zyd;

public class QWalletGdtAdManager$4
  implements Runnable
{
  public QWalletGdtAdManager$4(zyd paramzyd, String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.val$reportUrl).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.connect();
      int i = localHttpURLConnection.getResponseCode();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 1, "reportUrlByHttpGet rspCode" + i + ",reportUrl:" + this.val$reportUrl);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QWalletGdtAdManager", 2, "reportUrlByHttpGet error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.4
 * JD-Core Version:    0.7.0.1
 */