package com.tencent.mobileqq.activity.main;

import alkm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import zju;

public class MainAssistObserver$15
  implements Runnable
{
  public MainAssistObserver$15(zju paramzju, QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    int i = alkm.X(this.m) + this.d.bl();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTab = " + i);
    }
    this.m.runOnUiThread(new MainAssistObserver.15.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.15
 * JD-Core Version:    0.7.0.1
 */