package com.tencent.mobileqq.together.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

public class RoundRectView
  extends PressEffectImageView
{
  private int aiF;
  private int mBgColor = 0;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  
  public RoundRectView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RoundRectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = new RectF(0.0F, 0.0F, this.mWidth, this.mHeight);
    this.mPaint.setColor(this.mBgColor);
    paramCanvas.drawRoundRect(localRectF, this.aiF, this.aiF, this.mPaint);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.mWidth) && (paramInt2 == this.mHeight)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.aiF == i) {
      return;
    }
    this.aiF = i;
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.mBgColor == paramInt) {
      return;
    }
    this.mBgColor = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.RoundRectView
 * JD-Core Version:    0.7.0.1
 */