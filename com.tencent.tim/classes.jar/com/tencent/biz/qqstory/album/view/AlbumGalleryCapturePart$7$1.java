package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import pju;
import plh;
import plo;
import plq;
import ram;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(plo paramplo, List paramList, pju parampju) {}
  
  public void run()
  {
    if ((this.me != null) && (this.me.size() > 0))
    {
      plh.a(this.a.this$0).A(this.me);
      if ((plh.c(this.a.this$0) != -1) || (plh.a(this.a.this$0) != -1L)) {
        plh.a(this.a.this$0).sendEmptyMessage(1004);
      }
      this.c.start();
      ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.me.size()));
      return;
    }
    plh.a(this.a.this$0).blE();
    this.c.start();
    if (plh.c(this.a.this$0) != -1) {
      plh.a(this.a.this$0).sendEmptyMessage(1004);
    }
    plh.a(this.a.this$0).sendEmptyMessageDelayed(1005, 180000L);
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */