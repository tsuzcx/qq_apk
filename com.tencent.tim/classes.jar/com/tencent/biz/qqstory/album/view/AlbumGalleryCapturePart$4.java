package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import axwn;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import plh;
import rpq;

public class AlbumGalleryCapturePart$4
  implements Runnable
{
  public AlbumGalleryCapturePart$4(plh paramplh) {}
  
  public void run()
  {
    plh.a(this.this$0, true);
    View localView = plh.a(this.this$0).a(plh.a(this.this$0).getLayoutManager());
    if ((plh.b(this.this$0)) && (localView != null) && (plh.a(this.this$0).getPosition(localView) == 0)) {
      plh.a(this.this$0).smoothScrollBy(-(plh.a(this.this$0) - (int)rpq.b(plh.a(this.this$0).getContext(), 30.0F)), 0, 1250);
    }
    plh.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4
 * JD-Core Version:    0.7.0.1
 */