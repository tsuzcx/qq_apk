package com.tencent.qqmail.utilities;

import com.tencent.qqmail.model.mail.QMMailManager;

class AppStatusUtil$2$3
  implements Runnable
{
  AppStatusUtil$2$3(AppStatusUtil.2 param2) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().upgradeMailFts();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.2.3
 * JD-Core Version:    0.7.0.1
 */