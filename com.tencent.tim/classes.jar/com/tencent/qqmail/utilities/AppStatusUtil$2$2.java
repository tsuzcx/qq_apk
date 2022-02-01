package com.tencent.qqmail.utilities;

import com.tencent.qqmail.folderlist.QMFolderManager;

class AppStatusUtil$2$2
  implements Runnable
{
  AppStatusUtil$2$2(AppStatusUtil.2 param2) {}
  
  public void run()
  {
    QMFolderManager.sharedInstance().setAllHasNewMailToFalse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.2.2
 * JD-Core Version:    0.7.0.1
 */