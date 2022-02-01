package com.tencent.qqmail.model.mail;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

class QMMailCGIManager$33$1
  implements Runnable
{
  QMMailCGIManager$33$1(QMMailCGIManager.33 param33, String paramString, Activity paramActivity) {}
  
  public void run()
  {
    if (TextUtils.equals("1", this.val$event_expired))
    {
      Toast.makeText(this.val$activity, 2131718769, 0).show();
      return;
    }
    Toast.makeText(this.val$activity, 2131720014, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.33.1
 * JD-Core Version:    0.7.0.1
 */