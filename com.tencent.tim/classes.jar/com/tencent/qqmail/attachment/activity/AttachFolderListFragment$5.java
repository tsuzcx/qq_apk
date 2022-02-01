package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;

class AttachFolderListFragment$5
  implements View.OnClickListener
{
  AttachFolderListFragment$5(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AttachFolderListFragment.access$000(this.this$0) != null)
    {
      AttachFolderListFragment.access$000(this.this$0).checkUpdate();
      AttachFolderListFragment.access$900(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.5
 * JD-Core Version:    0.7.0.1
 */