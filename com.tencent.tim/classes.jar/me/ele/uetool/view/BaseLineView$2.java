package me.ele.uetool.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import me.ele.uetool.base.DimenUtil;

class BaseLineView$2
  extends Paint
{
  BaseLineView$2(BaseLineView paramBaseLineView, int paramInt)
  {
    super(paramInt);
    setColor(Color.parseColor("#FF0000"));
    setStyle(Paint.Style.STROKE);
    setStrokeWidth(DimenUtil.dip2px(0.5F));
    setPathEffect(new DashPathEffect(new float[] { DimenUtil.dip2px(3.0F), DimenUtil.dip2px(3.0F) }, 0.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.BaseLineView.2
 * JD-Core Version:    0.7.0.1
 */