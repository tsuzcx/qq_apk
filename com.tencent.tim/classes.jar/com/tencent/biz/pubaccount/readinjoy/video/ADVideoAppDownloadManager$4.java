package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import arvv;
import mrm;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  ADVideoAppDownloadManager$4(ADVideoAppDownloadManager paramADVideoAppDownloadManager, mrm parammrm) {}
  
  public void run()
  {
    this.a.mDownloadUrl = ADVideoAppDownloadManager.a(this.this$0, this.a.ajG, 1);
    if (!TextUtils.isEmpty(this.a.mDownloadUrl)) {
      arvv.a().fx(this.a.mDownloadUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */