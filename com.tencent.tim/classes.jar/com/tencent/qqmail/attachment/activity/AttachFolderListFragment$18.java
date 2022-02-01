package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;

class AttachFolderListFragment$18
  extends PtrListView.OnRefreshListener
{
  AttachFolderListFragment$18(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onRefresh()
  {
    if (AttachFolderListFragment.access$000(this.this$0) != null) {
      AttachFolderListFragment.access$000(this.this$0).checkUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.18
 * JD-Core Version:    0.7.0.1
 */