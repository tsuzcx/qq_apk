package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

class AttachFolderSearchListAdapter$5
  implements View.OnLongClickListener
{
  AttachFolderSearchListAdapter$5(AttachFolderSearchListAdapter paramAttachFolderSearchListAdapter, int paramInt, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    if (AttachFolderSearchListAdapter.access$100(this.this$0).getOnItemLongClickListener() != null)
    {
      AdapterView.OnItemLongClickListener localOnItemLongClickListener = AttachFolderSearchListAdapter.access$100(this.this$0).getOnItemLongClickListener();
      ListView localListView = AttachFolderSearchListAdapter.access$100(this.this$0);
      int i = this.val$position;
      localOnItemLongClickListener.onItemLongClick(localListView, paramView, AttachFolderSearchListAdapter.access$100(this.this$0).getHeaderViewsCount() + i, this.val$id);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListAdapter.5
 * JD-Core Version:    0.7.0.1
 */