package com.tencent.qqmail.ftn.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.animation.SmoothProgressBar;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.utilities.log.QMLog;

class FtnAttachmentActivity$20
  implements CompoundButton.OnCheckedChangeListener
{
  FtnAttachmentActivity$20(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QMLog.log(4, "FtnAttachmentActivity", "ftn click download:" + paramBoolean);
    if (FtnAttachmentActivity.access$5200(this.this$0)) {
      FtnAttachmentActivity.access$5300(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (FtnAttachmentActivity.access$100(this.this$0))
      {
        if (paramBoolean) {
          FtnAttachmentActivity.access$200(this.this$0).setProgressSmooth(FtnAttachmentActivity.access$200(this.this$0).getSchedule(), false);
        } else {
          FtnAttachmentActivity.access$200(this.this$0).cancelPb();
        }
      }
      else if (paramBoolean) {
        FtnAttachmentActivity.access$2300(this.this$0).goOnRequest(FtnAttachmentActivity.access$2400(this.this$0));
      } else {
        FtnAttachmentActivity.access$2300(this.this$0).abortRequest(FtnAttachmentActivity.access$2400(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.20
 * JD-Core Version:    0.7.0.1
 */