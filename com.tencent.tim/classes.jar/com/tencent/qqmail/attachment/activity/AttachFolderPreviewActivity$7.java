package com.tencent.qqmail.attachment.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachFolderPreviewActivity$7
  implements CompoundButton.OnCheckedChangeListener
{
  AttachFolderPreviewActivity$7(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.restoreDownload();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (AttachFolderPreviewActivity.access$1000(this.this$0) != null) {
        this.this$0.abortDownload(AttachFolderPreviewActivity.access$1000(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */