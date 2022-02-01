package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderPreviewActivity$11
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$11(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    AttachFolderPreviewActivity.access$1800(this.this$0, paramView);
    AttachFolderPreviewActivity.access$1900(this.this$0, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */