package com.tencent.mobileqq.minigame.ui;

import asts;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

class GameActivity$38
  implements Runnable
{
  GameActivity$38(GameActivity paramGameActivity, String paramString, long paramLong) {}
  
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
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd/BlockAd rspCode" + i);
      asts.F(this.this$0, this.val$reportUrl, this.val$timestamp);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd/BlockAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.38
 * JD-Core Version:    0.7.0.1
 */