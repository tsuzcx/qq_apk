package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class AppFolderListFragment$FolderOnRightViewClickListener$1
  implements Runnable
{
  AppFolderListFragment$FolderOnRightViewClickListener$1(AppFolderListFragment.FolderOnRightViewClickListener paramFolderOnRightViewClickListener, IListFolder paramIListFolder, int paramInt) {}
  
  public void run()
  {
    if (((QMFolder)this.val$folder.getData()).getType() != 130) {
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(this.val$folderId);
    }
    for (;;)
    {
      if (((QMFolder)this.val$folder.getData()).getType() == 130) {
        PopularizeManager.sharedInstance().updatePopularizeMoved(this.val$folderId, 1);
      }
      this.this$1.this$0.render(0);
      QMLog.log(4, "AppFolderListFragment", "move inner app to home to send config");
      return;
      FolderDataManager.moveAppFromInnerToHome(this.val$folderId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment.FolderOnRightViewClickListener.1
 * JD-Core Version:    0.7.0.1
 */