package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqnm;

public class TriangleView
  extends View
{
  public static final int LEFT = aqnm.dip2px(7.0F);
  public static final int caP = aqnm.dip2px(2.0F);
  public static final int caQ = aqnm.dip2px(2.0F);
  private int aiS = Color.parseColor("#00CAFC");
  private int direction = 1;
  
  public TriangleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TriangleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.aiS);
    localPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (this.direction == 0)
    {
      localPath.moveTo(i / 2, 0.0F);
      localPath.lineTo(i / 2 - LEFT, j);
      localPath.lineTo(i / 2 + LEFT, j);
    }
    for (;;)
    {
      localPath.close();
      paramCanvas.drawPath(localPath, localPaint);
      return;
      localPath.moveTo(i / 2, 0.0F);
      localPath.lineTo(i / 2 - LEFT, 0.0F);
      localPath.lineTo(i / 2 - caP, j - caQ);
      localPath.quadTo(i / 2, j, i / 2 + caP, j - caQ);
      localPath.lineTo(i / 2 + LEFT, 0.0F);
    }
  }
  
  public void setDirection(int paramInt)
  {
    this.direction = paramInt;
  }
  
  public void setDrawColor(int paramInt)
  {
    this.aiS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TriangleView
 * JD-Core Version:    0.7.0.1
 */