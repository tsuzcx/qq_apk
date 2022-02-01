package com.tencent.biz.qqstory.album.view;

import acfp;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import pju;
import pkd;
import plh;
import plk;
import pll;
import plq;
import psx;
import ram;
import rma;

public class AlbumGalleryCapturePart$12$1
  implements Runnable
{
  public AlbumGalleryCapturePart$12$1(plk paramplk, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.aAt)
    {
      ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album file not enough , delete album now , left pic size = %d", new Object[] { Integer.valueOf(this.a.c.getCount()) });
      plh.a(this.a.this$0).k(this.a.c);
      QQToast.a(plh.a(this.a.this$0), 1, acfp.m(2131702328), 0).show();
      plh.c(this.a.this$0, false);
      plh.a(this.a.this$0, -1L);
      return;
    }
    ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album select , goto slide show now , album id = %d", new Object[] { Long.valueOf(this.a.c.getID()) });
    rma.a().xL(21);
    rma.a().xK(13);
    rma.a().l(this.a.c);
    plh.a(this.a.this$0).u(0, 10000, 99, 0);
    rma.a().a(plh.a(this.a.this$0), new pll(this), 1);
    this.a.c.setState(1);
    ((pju)psx.a(30)).a(this.a.c);
    plh.a(this.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.12.1
 * JD-Core Version:    0.7.0.1
 */