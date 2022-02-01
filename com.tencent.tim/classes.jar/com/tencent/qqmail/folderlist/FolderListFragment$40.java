package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;

class FolderListFragment$40
  implements Runnable
{
  FolderListFragment$40(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    QMPushMailNotify.getInstance().cancelNotifyNewMail(FolderListFragment.access$200(this.this$0));
    if (QMSettingManager.sharedInstance().isFirstTimeFromTim())
    {
      QMSettingManager.sharedInstance().setFirstTimeFromTim(false);
      FolderListFragment.access$6600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.40
 * JD-Core Version:    0.7.0.1
 */