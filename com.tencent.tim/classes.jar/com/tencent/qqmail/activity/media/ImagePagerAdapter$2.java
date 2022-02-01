package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImagePagerAdapter$2
  implements View.OnClickListener
{
  ImagePagerAdapter$2(ImagePagerAdapter paramImagePagerAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    boolean[] arrayOfBoolean = ImagePagerAdapter.access$100(this.this$0);
    int i = this.val$position;
    if (ImagePagerAdapter.access$100(this.this$0)[this.val$position] == 0) {}
    for (int j = 1;; j = 0)
    {
      arrayOfBoolean[i] = j;
      if (ImagePagerAdapter.access$200(this.this$0) != null) {
        ImagePagerAdapter.access$200(this.this$0).setVisibilityOfBar();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */