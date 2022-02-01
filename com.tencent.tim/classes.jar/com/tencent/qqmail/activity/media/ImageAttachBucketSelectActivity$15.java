package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ImageAttachBucketSelectActivity$15
  implements View.OnClickListener
{
  ImageAttachBucketSelectActivity$15(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    ImageAttachBucketSelectActivity.access$2500(this.this$0, this.this$0.getIntent());
    DataCollector.logEvent("Event_Attach_BackToMail");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.15
 * JD-Core Version:    0.7.0.1
 */