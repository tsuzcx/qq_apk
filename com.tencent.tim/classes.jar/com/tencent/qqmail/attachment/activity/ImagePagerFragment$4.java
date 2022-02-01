package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImagePagerFragment$4
  implements View.OnClickListener
{
  ImagePagerFragment$4(ImagePagerFragment paramImagePagerFragment) {}
  
  public void onClick(View paramView)
  {
    ImagePagerFragment.access$900(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.4
 * JD-Core Version:    0.7.0.1
 */