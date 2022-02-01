package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.view.QMTopBar;

class AttachFolderPreviewActivity$10
  implements View.OnClickListener
{
  AttachFolderPreviewActivity$10(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!AttachFolderPreviewActivity.access$1600(this.this$0).isAnimFinish()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AttachFolderPreviewActivity.access$200(this.this$0).getButtonRight().setEnabled(true);
      if (AttachFolderPreviewActivity.access$000(this.this$0))
      {
        AttachFolderPreviewActivity.access$1600(this.this$0).slideBottom2Top(this.this$0, AttachFolderPreviewActivity.access$1700(this.this$0));
        paramView.setContentDescription(this.this$0.getString(2131720857));
      }
      else
      {
        AttachFolderPreviewActivity.access$1600(this.this$0).slideTop2Bottom(this.this$0, AttachFolderPreviewActivity.access$1700(this.this$0));
        paramView.setContentDescription(this.this$0.getString(2131720832));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.10
 * JD-Core Version:    0.7.0.1
 */