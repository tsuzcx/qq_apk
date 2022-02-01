package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;

class FolderListFragment$37
  implements BottleListController.UpdateUnreadStatusWatcher
{
  FolderListFragment$37(FolderListFragment paramFolderListFragment) {}
  
  public void onSuccessInMainThread(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((!FolderListFragment.access$4800(this.this$0)) && (paramBoolean))
    {
      FolderListFragment.access$800(this.this$0).updateBottleUnread(FolderListFragment.access$000(this.this$0));
      FolderListFragment.access$800(this.this$0).setMyAppUnreadRedDot(FolderListFragment.access$000(this.this$0));
      FolderDataManager.sharedInstance().setInnerBottleUnreadCount(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.37
 * JD-Core Version:    0.7.0.1
 */