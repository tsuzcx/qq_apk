package com.tencent.qqmail.attachment.activity;

class ImagePagerFragment$6
  implements Runnable
{
  ImagePagerFragment$6(ImagePagerFragment paramImagePagerFragment, ImagePagerActivity paramImagePagerActivity) {}
  
  public void run()
  {
    if (this.val$imagePager != null)
    {
      this.this$0.fetchImage();
      return;
    }
    ImagePagerFragment.access$700(this.this$0, "imagePager null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.6
 * JD-Core Version:    0.7.0.1
 */