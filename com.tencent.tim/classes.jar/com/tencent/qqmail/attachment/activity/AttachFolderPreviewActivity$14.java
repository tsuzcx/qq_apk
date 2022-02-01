package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderPreviewActivity$14
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$14(AttachFolderPreviewActivity paramAttachFolderPreviewActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.val$container.setVisibility(8);
    AttachFolderPreviewActivity.access$2200(this.this$0);
    this.this$0.directDownload();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */