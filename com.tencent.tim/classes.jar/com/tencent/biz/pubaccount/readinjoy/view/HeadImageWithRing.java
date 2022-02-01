package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;

public class HeadImageWithRing
  extends KanDianUrlRoundCornerImageView
{
  Paint aH;
  boolean aro;
  int center;
  int mColor;
  int mStrokeWidth;
  int r;
  
  public HeadImageWithRing(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.aro) {
      paramCanvas.drawCircle(this.center, this.center, this.r, this.aH);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r = ((int)((getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - this.mStrokeWidth) * 0.5F));
    this.center = ((int)((getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) * 0.5D + getPaddingLeft()));
    this.aH = new Paint(1);
    this.aH.setColor(this.mColor);
    this.aH.setStrokeWidth(this.mStrokeWidth);
    this.aH.setStyle(Paint.Style.STROKE);
  }
  
  public void setAttrs(int paramInt1, int paramInt2)
  {
    this.mStrokeWidth = paramInt1;
    this.mColor = paramInt2;
  }
  
  public void setDrawRing(boolean paramBoolean)
  {
    this.aro = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing
 * JD-Core Version:    0.7.0.1
 */