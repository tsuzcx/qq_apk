package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

class AttachFolderListAdapter$3
  implements View.OnLongClickListener
{
  AttachFolderListAdapter$3(AttachFolderListAdapter paramAttachFolderListAdapter, int paramInt, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    int i;
    int j;
    if (AttachFolderListAdapter.access$100(this.this$0).getOnItemLongClickListener() != null)
    {
      i = this.val$position;
      j = AttachFolderListAdapter.access$100(this.this$0).getHeaderViewsCount();
      if (!AttachFolderListAdapter.access$200(this.this$0)) {}
    }
    else
    {
      return false;
    }
    AttachFolderListAdapter.access$100(this.this$0).getOnItemLongClickListener().onItemLongClick(AttachFolderListAdapter.access$100(this.this$0), paramView, i + j, this.val$id);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListAdapter.3
 * JD-Core Version:    0.7.0.1
 */