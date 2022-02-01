package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import com.tencent.qqmail.scroller.ScreenScroller;

abstract class MGridScreenEffector
{
  protected static PaintFlagsDrawFilter DRAW_FILTER_HIGH_QUALITY = new PaintFlagsDrawFilter(0, 3);
  protected static PaintFlagsDrawFilter DRAW_FILTER_LOW_QUALITY = null;
  protected static PaintFlagsDrawFilter DRAW_FILTER_MID_QUALITY = new PaintFlagsDrawFilter(0, 1);
  protected float mCenterX;
  protected float mCenterY;
  protected boolean mCombineBackground;
  protected GridScreenContainer mContainer;
  protected float mHeight;
  protected int mQuality;
  protected ScreenScroller mScroller;
  protected float mWidth;
  
  static void drawScreen(GridScreenContainer paramGridScreenContainer, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramCanvas.save();
    paramCanvas.translate(paramInt4 + paramInt2, paramInt3);
    int i1 = paramGridScreenContainer.getCellRow();
    int i2 = paramGridScreenContainer.getCellCol();
    paramInt3 = i1 * i2 * paramInt1;
    int i3 = Math.min(paramGridScreenContainer.getCellCount(), i1 * i2 + paramInt3);
    int i4 = paramGridScreenContainer.getCellWidth();
    int i5 = paramGridScreenContainer.getCellHeight();
    int n = paramGridScreenContainer.getPaddingLeft();
    paramInt1 = paramGridScreenContainer.getPaddingTop();
    paramInt2 = 0;
    paramInt4 = 0;
    int i = 0;
    while ((i < i1) && (paramInt3 < i3))
    {
      int j = paramInt2;
      int m = 0;
      int k = n;
      paramInt2 = paramInt3;
      paramInt3 = j;
      j = paramInt4;
      paramInt4 = k;
      while ((m < i2) && (paramInt2 < i3))
      {
        paramCanvas.translate(paramInt4 - paramInt3, paramInt1 - j);
        paramGridScreenContainer.drawGridCell(paramCanvas, paramInt2);
        m += 1;
        paramInt2 += 1;
        paramInt3 = paramInt4;
        paramInt4 += i4;
        j = paramInt1;
      }
      k = paramInt1 + i5;
      i += 1;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
      paramInt4 = j;
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
    paramCanvas.restore();
  }
  
  static void drawScreenBackground(GridScreenContainer paramGridScreenContainer, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected static float interpolate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  void drawScreen(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramCanvas.save();
    paramCanvas.translate(paramInt2 + paramInt4, paramInt3);
    onDrawScreen(paramCanvas, paramInt1, paramInt2);
    paramCanvas.restore();
  }
  
  public boolean isCombineBackground()
  {
    return this.mCombineBackground;
  }
  
  protected boolean isCurrentScreenOnTop()
  {
    return false;
  }
  
  public void onAttach(GridScreenContainer paramGridScreenContainer, ScreenScroller paramScreenScroller)
  {
    this.mContainer = paramGridScreenContainer;
    this.mScroller = paramScreenScroller;
  }
  
  public void onDetach()
  {
    this.mContainer = null;
    this.mScroller = null;
  }
  
  abstract void onDrawScreen(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mCenterX = (paramInt1 * 0.5F);
    this.mCenterY = (paramInt2 * 0.5F);
  }
  
  protected final void requestQuality(Canvas paramCanvas, int paramInt)
  {
    switch (Math.min(paramInt, this.mQuality))
    {
    default: 
      return;
    case 1: 
      paramCanvas.setDrawFilter(DRAW_FILTER_MID_QUALITY);
      return;
    }
    paramCanvas.setDrawFilter(DRAW_FILTER_HIGH_QUALITY);
  }
  
  void setDrawQuality(int paramInt)
  {
    this.mQuality = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.effector.MGridScreenEffector
 * JD-Core Version:    0.7.0.1
 */