package com.tencent.mobileqq.nearby.picbrowser;

import akbo;
import akbr.a;

public class PicBrowserGalleryAdapter$3
  implements Runnable
{
  public PicBrowserGalleryAdapter$3(akbo paramakbo, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    akbo.a(this.this$0, this.val$position, this.val$isSuccess);
    if (akbo.a(this.this$0) != null) {
      akbo.a(this.this$0).onLoadFinish(this.val$position, this.val$isSuccess);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.3
 * JD-Core Version:    0.7.0.1
 */