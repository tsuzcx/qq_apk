package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

class QMPushManager$1$1
  implements QMGeneralCallback
{
  QMPushManager$1$1(QMPushManager.1 param1) {}
  
  public void onError() {}
  
  public void onSuccess()
  {
    QMServiceManager.setEnableUMAPush(false);
    SPManager.getEditor("Push_info").putInt("logined", this.this$0.val$logined + 1).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager.1.1
 * JD-Core Version:    0.7.0.1
 */