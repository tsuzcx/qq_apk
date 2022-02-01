package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.animation.SlideViewAnimation;

class FtnAttachmentActivity$10
  implements View.OnClickListener
{
  FtnAttachmentActivity$10(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onClick(View paramView)
  {
    FtnAttachmentActivity localFtnAttachmentActivity;
    if (FtnAttachmentActivity.access$2500(this.this$0))
    {
      FtnAttachmentActivity.access$2700(this.this$0).slideBottom2Top(this.this$0, FtnAttachmentActivity.access$2600(this.this$0));
      localFtnAttachmentActivity = this.this$0;
      if (FtnAttachmentActivity.access$2500(this.this$0)) {
        break label90;
      }
    }
    label90:
    for (int i = 2131720828;; i = 2131720829)
    {
      paramView.setContentDescription(localFtnAttachmentActivity.getString(i));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FtnAttachmentActivity.access$2700(this.this$0).slideTop2Bottom(this.this$0, FtnAttachmentActivity.access$2600(this.this$0));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.10
 * JD-Core Version:    0.7.0.1
 */