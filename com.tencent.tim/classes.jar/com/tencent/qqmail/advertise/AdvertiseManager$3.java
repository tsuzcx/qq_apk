package com.tencent.qqmail.advertise;

import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class AdvertiseManager$3
  implements DownloadTaskListener
{
  AdvertiseManager$3(AdvertiseManager paramAdvertiseManager, String paramString) {}
  
  public void onAbort(long paramLong, String paramString) {}
  
  public void onFail(long paramLong, String paramString, DownloadTaskError paramDownloadTaskError)
  {
    QMLog.log(4, "AdvertiseManager", "downloadPullDownImage onFail url = " + paramString);
  }
  
  public void onProgress(long paramLong1, String paramString, long paramLong2, long paramLong3) {}
  
  public void onStart(long paramLong, String paramString)
  {
    this.this$0.clearLastPushImage();
  }
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, "AdvertiseManager", "downloadPullDownImage onComplete url = " + paramString1 + " path = " + paramString2);
    SharedPreferenceUtil.setHasLastPushAdvertiseImage(true);
    SharedPreferenceUtil.setPullAdvertiseImageMd5(this.val$md5);
    Threads.runInBackground(new AdvertiseManager.3.1(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseManager.3
 * JD-Core Version:    0.7.0.1
 */