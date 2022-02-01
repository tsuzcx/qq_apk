package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderListFragment$9
  implements View.OnClickListener
{
  AttachFolderListFragment$9(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AttachFolderListFragment.access$1300(this.this$0)) {
      AttachFolderListFragment.access$1500(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.9
 * JD-Core Version:    0.7.0.1
 */