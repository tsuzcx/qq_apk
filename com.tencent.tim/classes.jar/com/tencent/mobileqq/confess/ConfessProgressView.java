package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ConfessProgressView
  extends View
{
  private float mHeight;
  private Paint mPaint = new Paint();
  private float mWidth;
  private float vM = 0.0F;
  private float vN;
  private float vO;
  
  public ConfessProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint.setColor(Color.argb(255, 252, 228, 80));
    this.mPaint.setAntiAlias(true);
  }
  
  public void Q(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 >= paramInt2)) {
      this.vM = 0.0F;
    }
    for (;;)
    {
      invalidate();
      return;
      int i = 80 / (paramInt2 - 1);
      this.mPaint.setColor(Color.argb(255, 252, 228 - i * (paramInt1 - 1), 80));
      float f1 = this.mWidth / 15.0F;
      float f2 = this.mWidth / 5.0F;
      if (paramInt1 == 1) {
        this.vM = f1;
      } else {
        this.vM = (f1 + (f2 - f1) / (paramInt2 - 2) * (paramInt1 - 1));
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.mWidth / 2.0F + this.vN, this.mHeight / 2.0F * 1.08F + this.vO, this.vM, this.mPaint);
  }
  
  public void setSize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
    this.vN = paramFloat3;
    this.vO = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessProgressView
 * JD-Core Version:    0.7.0.1
 */