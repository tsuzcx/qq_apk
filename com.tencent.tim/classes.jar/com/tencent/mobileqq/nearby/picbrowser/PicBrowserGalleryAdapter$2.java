package com.tencent.mobileqq.nearby.picbrowser;

import akbo;
import akbr.a;

public class PicBrowserGalleryAdapter$2
  implements Runnable
{
  public PicBrowserGalleryAdapter$2(akbo paramakbo, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    akbo.b(this.this$0, this.val$position, this.val$progress);
    if (akbo.a(this.this$0) != null) {
      akbo.a(this.this$0).onLoadProgressUpdate(this.val$position, this.val$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.2
 * JD-Core Version:    0.7.0.1
 */