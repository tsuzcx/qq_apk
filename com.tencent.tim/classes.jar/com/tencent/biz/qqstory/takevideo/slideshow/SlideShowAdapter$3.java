package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import aqcx;
import rlv;
import rlv.a;
import snb;

public class SlideShowAdapter$3
  implements Runnable
{
  public SlideShowAdapter$3(rlv paramrlv, rlv.a parama) {}
  
  public void run()
  {
    int i = this.b.yN.getWidth();
    int j = this.b.yN.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (rlv.a(this.this$0) == null)
    {
      int k = aqcx.dip2px(rlv.a(this.this$0), 1.0F);
      new Paint().setTextSize(aqcx.dip2px(rlv.a(this.this$0), 11.0F));
      int m = aqcx.dip2px(rlv.a(this.this$0), 2.0F);
      rlv.a(this.this$0, snb.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.b.yN.setBackgroundDrawable(new BitmapDrawable(rlv.a(this.this$0).getResources(), rlv.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */