package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.view.imageview.QMGestureImageView;

class ImagePagerAdapter$7
  implements Runnable
{
  ImagePagerAdapter$7(ImagePagerAdapter paramImagePagerAdapter, ImagePagerAdapter.TagData paramTagData) {}
  
  public void run()
  {
    if ((ImagePagerAdapter.access$1000(this.this$0) != 1) && (this.val$tagData.bitmap != null))
    {
      this.val$tagData.imageView.setRealH(this.val$tagData.bitmap.getHeight());
      this.val$tagData.imageView.setRealW(this.val$tagData.bitmap.getWidth());
    }
    if (this.val$tagData != null)
    {
      this.val$tagData.imageView.setImageBitmap(this.val$tagData.bitmap);
      this.val$tagData.layout.findViewById(2131367775).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.7
 * JD-Core Version:    0.7.0.1
 */