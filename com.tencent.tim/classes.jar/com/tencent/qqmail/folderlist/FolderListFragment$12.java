package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.observer.ICallBack;

class FolderListFragment$12
  implements ICallBack
{
  FolderListFragment$12(FolderListFragment paramFolderListFragment) {}
  
  public void callback(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QMFolder)))
    {
      int i = FolderListFragment.access$2900(this.this$0, (QMFolder)paramObject);
      if (i > 0) {
        FolderListFragment.access$1200(this.this$0, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.12
 * JD-Core Version:    0.7.0.1
 */