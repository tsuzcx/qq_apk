package com.tencent.biz.widgets;

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
    this.aJ.setColor(-1);
    this.path = new Path();
    this.aK = new Paint();
    this.aK.setColor(-2170912);
    this.aK.setStrokeWidth(2.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    int j = 150 + i * 2;
    int k = 150 + i;
    this.path.moveTo(k, 0.0F);
    this.path.lineTo('', i);
    this.path.lineTo(j, i);
    this.path.close();
    paramCanvas.drawPath(this.path, this.aJ);
    this.aK.setStrokeWidth(1.0F);
    paramCanvas.drawLine(k, 0.0F, '', i, this.aK);
    paramCanvas.drawLine(k, 0.0F, j, i, this.aK);
    this.aK.setStrokeWidth(2.0F);
    paramCanvas.drawLine(0.0F, i, '', i, this.aK);
    paramCanvas.drawLine(j, i, getMeasuredWidth(), i, this.aK);
  }
  
  public void setColor(int paramInt)
  {
    this.aJ.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.TriangleView
 * JD-Core Version:    0.7.0.1
 */