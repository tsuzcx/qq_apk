package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class AttachSaveToWeiYunActivity$1
  implements View.OnClickListener
{
  AttachSaveToWeiYunActivity$1(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void onClick(View paramView)
  {
    if (AttachSaveToWeiYunActivity.access$000(this.this$0))
    {
      DataCollector.logEvent("Event_Weiyun_Close_Transfering_Page");
      AttachSaveToWeiYunActivity.IS_TASK_LOADING = true;
    }
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.1
 * JD-Core Version:    0.7.0.1
 */