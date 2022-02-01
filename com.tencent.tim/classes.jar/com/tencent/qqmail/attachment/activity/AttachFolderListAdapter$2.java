package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderListAdapter$2
  implements View.OnClickListener
{
  AttachFolderListAdapter$2(AttachFolderListAdapter paramAttachFolderListAdapter, int paramInt, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (AttachFolderListAdapter.access$100(this.this$0).getOnItemClickListener() != null)
    {
      int i = this.val$position;
      int j = AttachFolderListAdapter.access$100(this.this$0).getHeaderViewsCount();
      AttachFolderListAdapter.access$100(this.this$0).getOnItemClickListener().onItemClick(AttachFolderListAdapter.access$100(this.this$0), paramView, i + j, this.val$id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListAdapter.2
 * JD-Core Version:    0.7.0.1
 */