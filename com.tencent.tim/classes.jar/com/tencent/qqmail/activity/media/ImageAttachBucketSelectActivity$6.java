package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImageAttachBucketSelectActivity$6
  implements View.OnClickListener
{
  ImageAttachBucketSelectActivity$6(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    ImageAttachBucketSelectActivity.access$000(this.this$0);
    ImageAttachBucketSelectActivity.access$1000(this.this$0, new ImageAttachBucketSelectActivity.6.1(this, paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.6
 * JD-Core Version:    0.7.0.1
 */