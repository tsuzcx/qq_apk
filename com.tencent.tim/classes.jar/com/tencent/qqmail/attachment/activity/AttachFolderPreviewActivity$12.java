package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class AttachFolderPreviewActivity$12
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$12(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    AttachFolderPreviewActivity.access$1800(this.this$0, paramView);
    DataCollector.logEvent("Event_Attach_Click_More_Btn_From_Attach_Detail");
    AttachFolderPreviewActivity.access$1900(this.this$0, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */