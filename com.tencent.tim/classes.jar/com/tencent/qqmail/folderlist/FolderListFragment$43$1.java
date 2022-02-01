package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class FolderListFragment$43$1
  implements Runnable
{
  FolderListFragment$43$1(FolderListFragment.43 param43, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = FolderListFragment.access$800(this.this$1.this$0).getCount() - 1;
    if (i >= 0)
    {
      Object localObject = FolderListFragment.access$800(this.this$1.this$0).getItem(i);
      if ((localObject == null) || (((IListFolder)localObject).getData() == null) || (((QMFolder)((IListFolder)localObject).getData()).getId() != this.val$folderId)) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject = (QMFolder)((IListFolder)localObject).getData();
        ((QMFolder)localObject).setCliUnreadCount(this.val$unreadCount);
        ((QMFolder)localObject).setHasNewMail(this.val$hasNewMail);
        FolderListFragment.access$5800(this.this$1.this$0);
        FolderListFragment.access$800(this.this$1.this$0).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.43.1
 * JD-Core Version:    0.7.0.1
 */