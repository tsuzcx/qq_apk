package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnLongClickListener;

class ImagePagerAdapter$4
  implements View.OnLongClickListener
{
  ImagePagerAdapter$4(ImagePagerAdapter paramImagePagerAdapter, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (ImagePagerAdapter.access$400(this.this$0) != null) {
      ImagePagerAdapter.access$400(this.this$0).onItemLongClick(this.val$position, paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.4
 * JD-Core Version:    0.7.0.1
 */