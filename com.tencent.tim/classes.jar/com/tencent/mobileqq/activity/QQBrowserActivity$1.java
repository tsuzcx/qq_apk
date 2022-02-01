package com.tencent.mobileqq.activity;

import arcp;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

class QQBrowserActivity$1
  implements Runnable
{
  QQBrowserActivity$1(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "start request: " + WebAccelerateHelper.isWebViewCache);
    }
    WebProcessManager.SZ(true);
    arcp.ehu();
    arcp.ehv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */