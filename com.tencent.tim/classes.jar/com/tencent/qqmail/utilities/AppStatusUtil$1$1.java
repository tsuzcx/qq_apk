package com.tencent.qqmail.utilities;

import com.tencent.qqmail.model.mail.QMMailManager;

class AppStatusUtil$1$1
  implements Runnable
{
  AppStatusUtil$1$1(AppStatusUtil.1 param1) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().checkAlignAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.1.1
 * JD-Core Version:    0.7.0.1
 */