package com.tencent.ttpic.filter;

import android.graphics.SurfaceTexture;
import com.tencent.view.RendererUtils;

class PagFilter$4
  implements Runnable
{
  PagFilter$4(PagFilter paramPagFilter) {}
  
  public void run()
  {
    if (PagFilter.access$200(this.this$0) != null) {
      PagFilter.access$200(this.this$0).release();
    }
    RendererUtils.clearTexture(PagFilter.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PagFilter.4
 * JD-Core Version:    0.7.0.1
 */