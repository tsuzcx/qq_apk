package com.tencent.mobileqq.nearby.picbrowser;

import akbo;
import akbr.a;

public class PicBrowserGalleryAdapter$1
  implements Runnable
{
  public PicBrowserGalleryAdapter$1(akbo paramakbo, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    akbo.a(this.this$0, this.val$position, this.val$progress);
    if (akbo.a(this.this$0) != null) {
      akbo.a(this.this$0).onLoadStart(this.val$position, this.val$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.1
 * JD-Core Version:    0.7.0.1
 */