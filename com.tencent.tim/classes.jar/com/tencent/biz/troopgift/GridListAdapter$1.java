package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import aqcx;
import snb;
import snb.a;

public class GridListAdapter$1
  implements Runnable
{
  public GridListAdapter$1(snb paramsnb, snb.a parama) {}
  
  public void run()
  {
    int i = aqcx.dip2px(this.this$0.mContext, 5.0F);
    new Paint().setTextSize(aqcx.dip2px(this.this$0.mContext, 11.0F));
    int j = this.a.fx.getWidth();
    int k = this.a.fx.getHeight();
    if ((j == 0) || (k == 0)) {
      return;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, i, i, i, i });
    localGradientDrawable.setColor(Color.argb(35, 0, 0, 0));
    this.a.fx.setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.1
 * JD-Core Version:    0.7.0.1
 */