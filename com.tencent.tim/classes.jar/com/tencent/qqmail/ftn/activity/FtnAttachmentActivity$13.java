package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class FtnAttachmentActivity$13
  implements View.OnClickListener
{
  FtnAttachmentActivity$13(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Attach_Click_More_Btn_From_Ftn_Detail");
    FtnAttachmentActivity.access$3200(this.this$0, Boolean.valueOf(FtnAttachmentActivity.access$100(this.this$0)), FtnAttachmentActivity.access$3100(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.13
 * JD-Core Version:    0.7.0.1
 */