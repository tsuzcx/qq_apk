package com.tencent.qqmail.launcher.base;

import com.tencent.qqmail.utilities.patch.QMPatchManager;

class WelcomeLoader$3
  implements Runnable
{
  WelcomeLoader$3(WelcomeLoader paramWelcomeLoader) {}
  
  public void run()
  {
    QMPatchManager.initLogger();
    QMPatchManager.checkPatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.3
 * JD-Core Version:    0.7.0.1
 */