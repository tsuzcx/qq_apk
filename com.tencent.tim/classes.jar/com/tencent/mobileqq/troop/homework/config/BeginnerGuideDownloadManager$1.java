package com.tencent.mobileqq.troop.homework.config;

import android.os.Handler;
import apgy;
import com.tencent.qphone.base.util.QLog;

public class BeginnerGuideDownloadManager$1
  implements Runnable
{
  public BeginnerGuideDownloadManager$1(apgy paramapgy, Handler paramHandler, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((!apgy.a(this.this$0, this.dD, this.dUg, this.cQr)) && (QLog.isColorLevel())) {
      QLog.d("BeginnerGuideDownloadManager", 2, "postDownload return false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */