package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderUnlockFolderActivity$3
  implements View.OnClickListener
{
  AttachFolderUnlockFolderActivity$3(AttachFolderUnlockFolderActivity paramAttachFolderUnlockFolderActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity.3
 * JD-Core Version:    0.7.0.1
 */