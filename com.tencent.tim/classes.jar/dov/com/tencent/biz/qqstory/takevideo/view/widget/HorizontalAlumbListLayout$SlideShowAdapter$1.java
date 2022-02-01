package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import aqcx;
import snb;

class HorizontalAlumbListLayout$SlideShowAdapter$1
  implements Runnable
{
  HorizontalAlumbListLayout$SlideShowAdapter$1(HorizontalAlumbListLayout.a parama, HorizontalAlumbListLayout.b paramb) {}
  
  public void run()
  {
    int i = this.a.yN.getWidth();
    int j = this.a.yN.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (HorizontalAlumbListLayout.a.a(this.b) == null)
    {
      int k = aqcx.dip2px(HorizontalAlumbListLayout.a.a(this.b), 1.0F);
      new Paint().setTextSize(aqcx.dip2px(HorizontalAlumbListLayout.a.a(this.b), 11.0F));
      int m = aqcx.dip2px(HorizontalAlumbListLayout.a.a(this.b), 2.0F);
      HorizontalAlumbListLayout.a.a(this.b, snb.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.yN.setBackgroundDrawable(new BitmapDrawable(HorizontalAlumbListLayout.a.a(this.b).getResources(), HorizontalAlumbListLayout.a.a(this.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1
 * JD-Core Version:    0.7.0.1
 */