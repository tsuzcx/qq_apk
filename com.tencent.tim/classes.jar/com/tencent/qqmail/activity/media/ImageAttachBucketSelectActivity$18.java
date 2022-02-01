package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImageAttachBucketSelectActivity$18
  implements View.OnClickListener
{
  ImageAttachBucketSelectActivity$18(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    ImageAttachBucketSelectActivity.access$3000(this.this$0, paramView);
    ImageAttachBucketSelectActivity.access$3100(this.this$0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.18
 * JD-Core Version:    0.7.0.1
 */