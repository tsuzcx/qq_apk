package com.tencent.qqmail.launcher.base;

import com.tencent.qqmail.model.mail.QMMailManager;

class WelcomeLoader$5
  implements Runnable
{
  WelcomeLoader$5(WelcomeLoader paramWelcomeLoader) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().recordUpgradeFtsIdList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.5
 * JD-Core Version:    0.7.0.1
 */