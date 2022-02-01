package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class BoxShadow
  extends FrameLayout
{
  int Dk;
  int dCb;
  private int lastHeight;
  private int lastWidth;
  RectF mCacheRect;
  Paint paint = new Paint();
  int shadowColor;
  
  public BoxShadow(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BoxShadow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.Dk = paramInt2;
    this.dCb = paramInt1;
    this.shadowColor = paramInt3;
    this.paint.setColor(this.shadowColor);
    this.paint.setStyle(Paint.Style.FILL);
    paramInt1 = (int)(0.5F * paramInt1);
    this.paint.setMaskFilter(new BlurMaskFilter(paramInt1, BlurMaskFilter.Blur.NORMAL));
    setLayerType(1, null);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.mCacheRect != null) {
      paramCanvas.drawRoundRect(this.mCacheRect, this.Dk, this.Dk, this.paint);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mCacheRect == null) || (this.lastWidth != getMeasuredWidth()) || (this.lastHeight != getMeasuredHeight()))
    {
      paramInt1 = (int)(0.5F * this.dCb);
      this.mCacheRect = new RectF(paramInt1, paramInt1, getMeasuredWidth() - paramInt1, getMeasuredHeight() - paramInt1 * 1.15F);
      this.lastWidth = getMeasuredWidth();
      this.lastHeight = getMeasuredHeight();
    }
  }
  
  public void setShadowColor(int paramInt)
  {
    if (this.shadowColor != paramInt)
    {
      this.shadowColor = paramInt;
      this.paint.setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BoxShadow
 * JD-Core Version:    0.7.0.1
 */