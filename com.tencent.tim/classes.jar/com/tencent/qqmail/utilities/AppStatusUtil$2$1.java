package com.tencent.qqmail.utilities;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.utilities.badge.BadgeUtil;

class AppStatusUtil$2$1
  implements Runnable
{
  AppStatusUtil$2$1(AppStatusUtil.2 param2) {}
  
  public void run()
  {
    QMFolderManager.sharedInstance().updateLatestUnread();
    QMFolderManager.sharedInstance().setAllHasNewMailToFalse();
    BadgeUtil.getInstance().clearBadge();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.2.1
 * JD-Core Version:    0.7.0.1
 */