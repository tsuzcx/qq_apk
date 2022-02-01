package com.tencent.qqmail.download.activity;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class DownloadActivity$5$1
  implements Runnable
{
  DownloadActivity$5$1(DownloadActivity.5 param5, String paramString) {}
  
  public void run()
  {
    DownloadActivity.access$300(this.this$1.this$0).hide();
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131692957), 0).show();
    QMLog.log(5, "DownloadActivity", "get FTN share url fail:" + this.val$fileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.5.1
 * JD-Core Version:    0.7.0.1
 */