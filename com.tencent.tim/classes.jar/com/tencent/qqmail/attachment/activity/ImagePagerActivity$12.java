package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ImagePagerActivity$12
  implements View.OnClickListener
{
  ImagePagerActivity$12(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onClick(View paramView)
  {
    ImagePagerActivity.access$1800(this.this$0, paramView);
    ImagePagerActivity.access$2300(this.this$0);
    DataCollector.logEvent("Event_Attach_Click_More_Btn_From_Ftn_Detail");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.12
 * JD-Core Version:    0.7.0.1
 */