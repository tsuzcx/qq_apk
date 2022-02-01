package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TriangleView
  extends View
{
  Paint aJ = new Paint();
  Paint aK;
  Path path;
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aJ.setColor(-2013265920);
    this.path = new Path();
    this.aK = new Paint();
    this.aK.setColor(-2013265920);
    this.aK.setStrokeWidth(1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    this.path.moveTo(0, 0.0F);
    this.path.lineTo(0 + i, i);
    this.path.lineTo(i * 2 + 0, 0.0F);
    this.path.close();
    paramCanvas.drawPath(this.path, this.aJ);
  }
  
  public void setColor(int paramInt)
  {
    this.aJ.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.TriangleView
 * JD-Core Version:    0.7.0.1
 */