package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import com.tencent.qqmail.scroller.ScreenScroller;

abstract class MSubScreenEffector
{
  protected static final int ALPHA = 255;
  protected static PaintFlagsDrawFilter DRAW_FILTER_HIGH_QUALITY = new PaintFlagsDrawFilter(0, 3);
  protected static PaintFlagsDrawFilter DRAW_FILTER_LOW_QUALITY = null;
  protected static PaintFlagsDrawFilter DRAW_FILTER_MID_QUALITY = new PaintFlagsDrawFilter(0, 1);
  protected static final float HALF = 0.5F;
  protected int mAlpha = 255;
  protected float mCenterX;
  protected float mCenterY;
  protected SubScreenContainer mContainer;
  protected boolean mNeedQuality = true;
  protected int mOrientation;
  protected int mOvershootPercent = 0;
  protected int mQuality;
  protected boolean mReverse = false;
  protected int mScroll;
  protected ScreenScroller mScroller;
  
  static void drawView(SubScreenContainer paramSubScreenContainer, ScreenScroller paramScreenScroller, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramScreenScroller.getOrientation();
    int j = paramScreenScroller.getScroll();
    int k = paramSubScreenContainer.getWidth();
    int m = paramSubScreenContainer.getHeight();
    paramCanvas.save();
    if (i == 0) {
      paramCanvas.translate(j + paramInt2, paramInt3);
    }
    for (;;)
    {
      paramCanvas.clipRect(0, 0, k, m);
      paramSubScreenContainer.drawScreen(paramCanvas, paramInt1);
      paramCanvas.restore();
      return;
      paramCanvas.translate(0.0F, j + paramInt2);
    }
  }
  
  protected void drawView(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    if (this.mNeedQuality) {
      requestQuality(paramCanvas, 2);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, paramInt3);
    if (onDrawScreen(paramCanvas, paramInt1, paramInt2, paramBoolean))
    {
      if (this.mAlpha != 255) {
        break label79;
      }
      this.mContainer.drawScreen(paramCanvas, paramInt1);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      paramCanvas.setDrawFilter(localDrawFilter);
      return;
      label79:
      if (this.mAlpha > 0) {
        this.mContainer.drawScreen(paramCanvas, paramInt1, this.mAlpha);
      }
    }
  }
  
  public int getMaxOvershootPercent()
  {
    return this.mOvershootPercent;
  }
  
  protected void onAttach(SubScreenContainer paramSubScreenContainer, ScreenScroller paramScreenScroller)
  {
    this.mContainer = paramSubScreenContainer;
    this.mScroller = paramScreenScroller;
    this.mScroller.setOvershootPercent(this.mOvershootPercent);
    onSizeChanged();
  }
  
  protected void onDetach()
  {
    this.mScroller = null;
    this.mContainer = null;
  }
  
  protected abstract boolean onDrawScreen(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean);
  
  protected void onScrollChanged(int paramInt1, int paramInt2)
  {
    this.mScroll = paramInt1;
  }
  
  public void onSizeChanged() {}
  
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
  
  protected boolean toReverse()
  {
    return this.mReverse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.effector.MSubScreenEffector
 * JD-Core Version:    0.7.0.1
 */