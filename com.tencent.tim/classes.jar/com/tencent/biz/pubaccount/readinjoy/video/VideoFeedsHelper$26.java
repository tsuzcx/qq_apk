package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

public final class VideoFeedsHelper$26
  implements Runnable
{
  public VideoFeedsHelper$26(String paramString) {}
  
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
        QLog.d("VideoFeedsHelper", 2, "asyncHttpReport reportUrl = " + this.val$reportUrl + ", rspCode:" + i);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("VideoFeedsHelper", 1, "asyncHttpReport error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.26
 * JD-Core Version:    0.7.0.1
 */