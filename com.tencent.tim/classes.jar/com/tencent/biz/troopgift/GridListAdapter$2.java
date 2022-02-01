package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import aqcx;
import snb;
import snb.a;
import sne;

public class GridListAdapter$2
  implements Runnable
{
  public GridListAdapter$2(snb paramsnb, snb.a parama, sne paramsne, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Snb$a.ql.getWidth();
    int j = this.jdField_a_of_type_Snb$a.ql.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = aqcx.dip2px(this.this$0.mContext, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(aqcx.dip2px(this.this$0.mContext, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_Sne.aEV);
    float f2 = aqcx.dip2px(this.this$0.mContext, 2.0F);
    int m = aqcx.dip2px(this.this$0.mContext, 1.0F);
    this.jdField_a_of_type_Snb$a.ql.setBackgroundDrawable(new BitmapDrawable(this.this$0.mContext.getResources(), snb.a(i, j, k, f1 + f2, m, this.bxR)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.2
 * JD-Core Version:    0.7.0.1
 */