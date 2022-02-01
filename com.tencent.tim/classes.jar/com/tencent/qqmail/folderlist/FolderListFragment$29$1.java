package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;
import com.tencent.qqmail.view.QMBaseView;

class FolderListFragment$29$1
  implements ListViewHelper.OnHandleNextUnread
{
  FolderListFragment$29$1(FolderListFragment.29 param29) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    QMBaseView localQMBaseView = (QMBaseView)FolderListFragment.access$5700(this.this$1.this$0);
    if (paramInt1 == -1)
    {
      localQMBaseView.scrollToTop();
      return;
    }
    localQMBaseView.scrollToPosition(paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    ((QMBaseView)FolderListFragment.access$5600(this.this$1.this$0)).scrollToTop();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.29.1
 * JD-Core Version:    0.7.0.1
 */