package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class AttachFolderPreviewActivity$17
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$17(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Attach_Open_File_From_AttachDetail");
    AttachFolderPreviewActivity.access$2300(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.17
 * JD-Core Version:    0.7.0.1
 */