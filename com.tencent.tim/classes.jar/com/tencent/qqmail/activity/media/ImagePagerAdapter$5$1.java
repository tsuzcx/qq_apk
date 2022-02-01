package com.tencent.qqmail.activity.media;

import android.view.View;

class ImagePagerAdapter$5$1
  implements Runnable
{
  ImagePagerAdapter$5$1(ImagePagerAdapter.5 param5, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.this$1.val$layout.getParent() != null)
    {
      ImagePagerAdapter.TagData localTagData = (ImagePagerAdapter.TagData)this.this$1.val$layout.getTag();
      if (this.val$url.equals(localTagData.imageUrl)) {
        ImagePagerAdapter.access$500(this.this$1.this$0, this.val$url, this.val$readLen, this.val$totalBytesRead, localTagData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */