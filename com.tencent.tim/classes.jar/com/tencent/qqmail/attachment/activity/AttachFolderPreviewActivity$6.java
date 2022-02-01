package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class AttachFolderPreviewActivity$6
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$6(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    AttachFolderPreviewActivity.access$1400(this.this$0);
    DataCollector.logEvent("Event_Attach_BackToMail");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */