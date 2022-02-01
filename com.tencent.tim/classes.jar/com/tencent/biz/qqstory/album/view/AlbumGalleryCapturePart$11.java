package com.tencent.biz.qqstory.album.view;

import axwn;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import plh;
import ram;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(plh paramplh) {}
  
  public void run()
  {
    if (plh.b(this.this$0))
    {
      ram.d("FredguoFix", "play animation");
      plh.a(this.this$0).a(null);
      boolean bool1 = plh.a(this.this$0).post(plh.a(this.this$0));
      boolean bool2 = plh.a(this.this$0).postDelayed(plh.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        plh.a(this.this$0).a(plh.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */