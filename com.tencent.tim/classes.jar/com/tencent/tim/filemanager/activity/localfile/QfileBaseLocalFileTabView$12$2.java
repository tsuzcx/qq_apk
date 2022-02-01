package com.tencent.tim.filemanager.activity.localfile;

import atrc;
import attk;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;

public class QfileBaseLocalFileTabView$12$2
  implements Runnable
{
  public QfileBaseLocalFileTabView$12$2(atrc paramatrc, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.a.this$0.refreshList();
    QfileBaseLocalFileTabView.d(this.a.this$0).a().jp(this.Yo);
    if (!this.val$isSuccess)
    {
      audx.n(this.Yo, this.val$errCode, this.amt);
      return;
    }
    audx.jQ(this.Yo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView.12.2
 * JD-Core Version:    0.7.0.1
 */