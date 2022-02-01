package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderListFragment$2
  implements Runnable
{
  FolderListFragment$2(FolderListFragment paramFolderListFragment, IListFolder paramIListFolder, int paramInt) {}
  
  public void run()
  {
    if (((QMFolder)this.val$folder.getData()).getType() != 130)
    {
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(this.val$folderId);
      if (((QMFolder)this.val$folder.getData()).getType() == 130) {
        PopularizeManager.sharedInstance().updatePopularizeMoved(this.val$folderId, 2);
      }
      if (this.val$folderId != -5) {
        break label98;
      }
      FolderDataManager.sharedInstance().syncInnerFtnUnreadCount();
    }
    for (;;)
    {
      FolderListFragment.access$1400(this.this$0);
      QMLog.log(4, "FolderListFragment", "move home app to inner to send config");
      return;
      FolderDataManager.moveAppFromHomeToInner(this.val$folderId);
      break;
      label98:
      if (this.val$folderId == -16) {
        FolderDataManager.sharedInstance().syncInnerBottleUnreadCount();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.2
 * JD-Core Version:    0.7.0.1
 */