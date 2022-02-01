package com.tencent.mobileqq.nearby.picbrowser;

import akbr;
import akbr.a;
import com.tencent.image.URLDrawable;

public class PicBrowserImage$3
  implements Runnable
{
  public PicBrowserImage$3(akbr paramakbr, URLDrawable paramURLDrawable, akbr.a parama, int paramInt) {}
  
  public void run()
  {
    if ((this.G.getStatus() != 1) && (this.G.getStatus() != 2)) {
      this.b.onLoadStart(this.val$position, this.G.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.3
 * JD-Core Version:    0.7.0.1
 */