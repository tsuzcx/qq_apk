package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.BottleOpenNotifyWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderListFragment$36
  implements BottleOpenNotifyWatcher
{
  FolderListFragment$36(FolderListFragment paramFolderListFragment) {}
  
  public void onNotify(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMLog.log(4, "FolderListFragment", "mBottleOpenNotifyWatcher: opened");
      int i = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
      if (i != -1) {
        FolderListFragment.access$2200(this.this$0).sync(i);
      }
      FolderListFragment.access$6400(this.this$0, new FolderListFragment.36.1(this));
      FolderListFragment.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.36
 * JD-Core Version:    0.7.0.1
 */