package com.tencent.qqmail.launcher.base;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.QQBrowserUtil;

class WelcomeLoader$6
  implements Runnable
{
  WelcomeLoader$6(WelcomeLoader paramWelcomeLoader) {}
  
  public void run()
  {
    QQBrowserUtil.init(QMApplicationContext.sharedInstance());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.6
 * JD-Core Version:    0.7.0.1
 */