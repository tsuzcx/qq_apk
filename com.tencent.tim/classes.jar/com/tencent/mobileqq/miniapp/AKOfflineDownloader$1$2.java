package com.tencent.mobileqq.miniapp;

import ajci;
import ajcj;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class AKOfflineDownloader$1$2
  implements Runnable
{
  public AKOfflineDownloader$1$2(ajcj paramajcj) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.val$bid);
    localBundle.putString("path", ajci.bg(this.a.val$bid, ""));
    ajci.b(this.a.a.E(localBundle), this.a.val$url, this.a.val$src, 3, this.a.val$bid, this.a.val$tag);
    QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(System.currentTimeMillis() - this.a.val$startTime) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2
 * JD-Core Version:    0.7.0.1
 */