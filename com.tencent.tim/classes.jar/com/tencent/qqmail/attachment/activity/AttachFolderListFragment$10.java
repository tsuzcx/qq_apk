package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class AttachFolderListFragment$10
  implements View.OnClickListener
{
  AttachFolderListFragment$10(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    AttachFolderListFragment.access$1600(this.this$0);
    DataCollector.logEvent("Event_Attach_Add_To_Compose");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.10
 * JD-Core Version:    0.7.0.1
 */