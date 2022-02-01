package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.view.QMTopBar;

class FtnAttachmentActivity$9
  implements View.OnClickListener
{
  FtnAttachmentActivity$9(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onClick(View paramView)
  {
    FtnAttachmentActivity.access$2200(this.this$0).getButtonLeft().setSelected(true);
    if (FtnAttachmentActivity.access$2300(this.this$0) != null) {
      FtnAttachmentActivity.access$2300(this.this$0).abortAndRemoveRequest(FtnAttachmentActivity.access$2400(this.this$0));
    }
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.9
 * JD-Core Version:    0.7.0.1
 */