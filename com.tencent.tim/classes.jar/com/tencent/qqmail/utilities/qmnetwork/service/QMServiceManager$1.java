package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

final class QMServiceManager$1
  implements QMGeneralCallback
{
  public void onError() {}
  
  public void onSuccess()
  {
    QMServiceManager.getWebPushEditor().remove("need_uma_login").apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager.1
 * JD-Core Version:    0.7.0.1
 */