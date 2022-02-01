package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.HttpURLConnection;
import java.net.URL;

class BlockAdPlugin$6
  implements Runnable
{
  BlockAdPlugin$6(BlockAdPlugin paramBlockAdPlugin, String paramString) {}
  
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
      QMLog.i("BlockAdPlugin", "reportBlockAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.i("BlockAdPlugin", "reportBlockAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.6
 * JD-Core Version:    0.7.0.1
 */