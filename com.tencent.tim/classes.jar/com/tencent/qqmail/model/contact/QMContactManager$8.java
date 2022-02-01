package com.tencent.qqmail.model.contact;

import android.app.Activity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.permission.RxPermissions;
import rx.Observable;

class QMContactManager$8
  implements Runnable
{
  QMContactManager$8(QMContactManager paramQMContactManager) {}
  
  public void run()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null) {
      RxPermissions.getInstance(localActivity).request(new String[] { "android.permission.READ_CONTACTS" }).subscribe(new QMContactManager.8.1(this, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.8
 * JD-Core Version:    0.7.0.1
 */