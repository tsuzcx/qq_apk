package com.tencent.mobileqq.app;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;

class QQAppInterface$1
  implements Runnable
{
  QQAppInterface$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface.cu(this.this$0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    localIntentFilter.addAction("com.tecent.qzone.clearAlbumRedTouch");
    QQAppInterface.c(this.this$0).registerReceiver(QQAppInterface.a(this.this$0), localIntentFilter);
    VideoBroadcastReceiver.cy(this.this$0);
    if (this.this$0.abl()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.1
 * JD-Core Version:    0.7.0.1
 */