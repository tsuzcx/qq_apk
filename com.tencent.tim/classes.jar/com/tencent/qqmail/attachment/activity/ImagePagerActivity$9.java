package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.animation.SlideViewAnimation;

class ImagePagerActivity$9
  implements View.OnClickListener
{
  ImagePagerActivity$9(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onClick(View paramView)
  {
    if (ImagePagerActivity.access$1500(this.this$0)) {
      ImagePagerActivity.access$1700(this.this$0).slideBottom2Top(this.this$0, ImagePagerActivity.access$1600(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ImagePagerActivity.access$1700(this.this$0).slideTop2Bottom(this.this$0, ImagePagerActivity.access$1600(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.9
 * JD-Core Version:    0.7.0.1
 */