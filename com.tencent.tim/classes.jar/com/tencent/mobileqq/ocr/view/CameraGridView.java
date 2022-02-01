package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import wja;

public class CameraGridView
  extends View
{
  private int dnY = 2;
  private int dnZ = 2;
  private int height;
  private Paint mPaint;
  private int width;
  
  public CameraGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(wja.dp2px(0.5F, getResources()));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 1;
    super.onDraw(paramCanvas);
    int n = this.width / (this.dnY + 1);
    int m = this.height / (this.dnZ + 1);
    int i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i > this.dnY) {
        break;
      }
      paramCanvas.drawLine(n * i, 0.0F, n * i, this.height, this.mPaint);
      i += 1;
    }
    while (j <= this.dnZ)
    {
      paramCanvas.drawLine(0.0F, m * j, this.width, m * j, this.mPaint);
      j += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CameraGridView
 * JD-Core Version:    0.7.0.1
 */