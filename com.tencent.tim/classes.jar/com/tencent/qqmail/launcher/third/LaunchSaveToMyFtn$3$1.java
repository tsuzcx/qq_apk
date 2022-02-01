package com.tencent.qqmail.launcher.third;

import com.tencent.qqmail.ftn.Ftn.ItemOutputStoreFile;
import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.LinkedList;

class LaunchSaveToMyFtn$3$1
  implements Runnable
{
  LaunchSaveToMyFtn$3$1(LaunchSaveToMyFtn.3 param3, StoreFileOutput paramStoreFileOutput) {}
  
  public void run()
  {
    if ((this.val$storeFileOutput != null) && (this.val$storeFileOutput.itemlist != null) && (this.val$storeFileOutput.itemlist.size() == 1))
    {
      ItemOutputStoreFile localItemOutputStoreFile = (ItemOutputStoreFile)this.val$storeFileOutput.itemlist.get(0);
      if ((localItemOutputStoreFile.ret == -106) || (localItemOutputStoreFile.ret == -109) || (localItemOutputStoreFile.ret == -99))
      {
        QMLog.log(4, "LaunchSaveToMyFtn", "trigger exist ftn file");
        QMWatcherCenter.triggerWtchatFtnError(localItemOutputStoreFile.ret);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QMLog.log(4, "LaunchSaveToMyFtn", "trigger save ftn success");
        QMWatcherCenter.triggerWtchatFtnSuccess();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn.3.1
 * JD-Core Version:    0.7.0.1
 */