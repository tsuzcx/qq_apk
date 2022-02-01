package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;

class FolderListFragment$36$1
  implements Runnable
{
  FolderListFragment$36$1(FolderListFragment.36 param36) {}
  
  public void run()
  {
    BottleManager localBottleManager = BottleManager.getInstance();
    if (localBottleManager != null) {
      localBottleManager.getBottleListController().bindUpdateUnreadStatusWatcher(FolderListFragment.access$6300(this.this$1.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.36.1
 * JD-Core Version:    0.7.0.1
 */