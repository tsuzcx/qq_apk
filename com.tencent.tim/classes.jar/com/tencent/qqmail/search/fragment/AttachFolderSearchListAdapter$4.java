package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderSearchListAdapter$4
  implements View.OnClickListener
{
  AttachFolderSearchListAdapter$4(AttachFolderSearchListAdapter paramAttachFolderSearchListAdapter, int paramInt, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (AttachFolderSearchListAdapter.access$100(this.this$0).getOnItemClickListener() != null)
    {
      AdapterView.OnItemClickListener localOnItemClickListener = AttachFolderSearchListAdapter.access$100(this.this$0).getOnItemClickListener();
      ListView localListView = AttachFolderSearchListAdapter.access$100(this.this$0);
      int i = this.val$position;
      localOnItemClickListener.onItemClick(localListView, paramView, AttachFolderSearchListAdapter.access$100(this.this$0).getHeaderViewsCount() + i, this.val$id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListAdapter.4
 * JD-Core Version:    0.7.0.1
 */