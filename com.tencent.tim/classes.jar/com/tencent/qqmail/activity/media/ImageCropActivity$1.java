package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImageCropActivity$1
  implements View.OnClickListener
{
  ImageCropActivity$1(ImageCropActivity paramImageCropActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setResult(2);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageCropActivity.1
 * JD-Core Version:    0.7.0.1
 */