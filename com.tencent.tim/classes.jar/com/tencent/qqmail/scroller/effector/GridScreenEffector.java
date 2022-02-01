package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.qqmail.scroller.ScreenScroller;
import com.tencent.qqmail.scroller.ScreenScrollerEffector;
import com.tencent.qqmail.scroller.ScreenScrollerListener;

public class GridScreenEffector
  implements ScreenScrollerEffector
{
  private static final Interpolator DECELE_RATE_INTER_POLATOR3;
  private static final Interpolator DECELE_RATE_INTER_POLATOR5;
  public static final int DRAW_QUALITY_HIGH = 2;
  public static final int DRAW_QUALITY_LOW = 0;
  public static final int DRAW_QUALITY_MID = 1;
  GridScreenContainer mContainer;
  int mCurrentIndex;
  MGridScreenEffector mEffector;
  int mGap;
  int mOrientation;
  int mQuality;
  MGridScreenEffector[] mRandomEffectors;
  ScreenScroller mScroller;
  int mTopPadding;
  int mType;
  
  static
  {
    if (!GridScreenEffector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      DECELE_RATE_INTER_POLATOR3 = new DecelerateInterpolator(1.5F);
      DECELE_RATE_INTER_POLATOR5 = new DecelerateInterpolator(2.5F);
      return;
    }
  }
  
  public GridScreenEffector(ScreenScroller paramScreenScroller)
  {
    assert (paramScreenScroller != null);
    this.mScroller = paramScreenScroller;
    this.mScroller.setEffector(this);
  }
  
  public int getMaxOvershootPercent()
  {
    return 0;
  }
  
  public void onAttach(ScreenScrollerListener paramScreenScrollerListener)
  {
    if ((paramScreenScrollerListener != null) && ((paramScreenScrollerListener instanceof GridScreenContainer)))
    {
      ScreenScroller localScreenScroller = paramScreenScrollerListener.getScreenScroller();
      this.mContainer = ((GridScreenContainer)paramScreenScrollerListener);
      if (localScreenScroller == null) {
        throw new IllegalArgumentException("Container has no ScreenScroller.");
      }
      if (this.mScroller != localScreenScroller)
      {
        this.mScroller = localScreenScroller;
        this.mOrientation = this.mScroller.getOrientation();
        int i = this.mType;
        this.mType = 0;
        this.mEffector = null;
        setType(i);
      }
      return;
    }
    throw new IllegalArgumentException("container is not an instance of GridScreenEffector.GridScreenContainer");
  }
  
  public void onDetach()
  {
    this.mContainer = null;
    this.mScroller = null;
    if (this.mEffector != null) {
      this.mEffector.onDetach();
    }
  }
  
  public boolean onDraw(Canvas paramCanvas)
  {
    if (this.mOrientation == 1) {
      return false;
    }
    int j = this.mScroller.getDrawingScreenA();
    int k = this.mScroller.getDrawingScreenB();
    int m = this.mScroller.getScroll() + this.mGap * 2;
    int i = this.mScroller.getCurrentScreenOffset();
    int n = this.mScroller.getFirstVisiableScreenSize();
    if (i > 0) {
      i -= n;
    }
    for (;;)
    {
      int i1 = this.mTopPadding;
      if ((i == 0) && (this.mScroller.getCurrentDepth() == 0.0F))
      {
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, j - 1, i - n, i1, m);
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, j, i, i1, m);
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, j + 1, i + n, i1, m);
        MGridScreenEffector.drawScreen(this.mContainer, paramCanvas, j, i, i1, m);
      }
      for (;;)
      {
        return true;
        if (this.mEffector != null) {
          break;
        }
        MGridScreenEffector.drawScreen(this.mContainer, paramCanvas, j, i, i1, m);
        MGridScreenEffector.drawScreen(this.mContainer, paramCanvas, k, i + n, i1, m);
      }
      paramCanvas.save();
      if ((this.mEffector.isCurrentScreenOnTop()) && (j == this.mScroller.getCurrentScreen()))
      {
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, k, i + n, i1, m);
        this.mEffector.drawScreen(paramCanvas, k, i + n, i1, m);
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, j, i, i1, m);
        this.mEffector.drawScreen(paramCanvas, j, i, i1, m);
      }
      for (;;)
      {
        paramCanvas.restore();
        break;
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, j, i, i1, m);
        this.mEffector.drawScreen(paramCanvas, j, i, i1, m);
        MGridScreenEffector.drawScreenBackground(this.mContainer, paramCanvas, k, i + n, i1, m);
        this.mEffector.drawScreen(paramCanvas, k, i + n, i1, m);
      }
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mOrientation = this.mScroller.getOrientation();
    if (this.mEffector != null) {
      this.mEffector.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void recycle()
  {
    this.mRandomEffectors = null;
  }
  
  public void setDrawQuality(int paramInt)
  {
    this.mQuality = paramInt;
    if (this.mEffector != null) {
      this.mEffector.setDrawQuality(paramInt);
    }
  }
  
  public void setScreenGap(int paramInt)
  {
    this.mGap = paramInt;
  }
  
  public void setTopPadding(int paramInt)
  {
    this.mTopPadding = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void updateRandomEffect()
  {
    if (this.mType == -1) {
      setType(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.effector.GridScreenEffector
 * JD-Core Version:    0.7.0.1
 */