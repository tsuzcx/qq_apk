package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class GradientProgressView
  extends View
{
  SweepGradient c;
  int endColor = -1;
  Paint paint = new Paint();
  RectF rectF;
  int rotate = 0;
  int startColor = 0;
  int strokeWidth = 5;
  
  public GradientProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void kb(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int i = this.startColor;
      int j = this.endColor;
      this.c = new SweepGradient(paramInt1 / 2, paramInt2 / 2, new int[] { i, j }, new float[] { 0.0F, 1.0F });
      this.rectF = new RectF(this.strokeWidth, this.strokeWidth, paramInt1 - this.strokeWidth, paramInt2 - this.strokeWidth);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setAntiAlias(true);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setShader(this.c);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.rotate += 3;
    if (this.rotate > 360) {
      this.rotate -= 360;
    }
    paramCanvas.rotate(this.rotate, i / 2, j / 2);
    paramCanvas.drawArc(this.rectF, 0.0F, 360.0F, true, this.paint);
    postInvalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    kb(paramInt1, paramInt2);
  }
  
  public void setEndColor(int paramInt)
  {
    this.endColor = paramInt;
    kb(getWidth(), getHeight());
  }
  
  public void setStartColor(int paramInt)
  {
    this.startColor = paramInt;
    kb(getWidth(), getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GradientProgressView
 * JD-Core Version:    0.7.0.1
 */