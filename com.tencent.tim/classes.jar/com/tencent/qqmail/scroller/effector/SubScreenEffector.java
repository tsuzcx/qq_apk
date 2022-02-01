package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;
import com.tencent.qqmail.scroller.ScreenScroller;
import com.tencent.qqmail.scroller.ScreenScrollerEffector;
import com.tencent.qqmail.scroller.ScreenScrollerListener;

public class SubScreenEffector
  implements ScreenScrollerEffector
{
  public static final int DRAW_QUALITY_HIGH = 2;
  public static final int DRAW_QUALITY_LOW = 0;
  public static final int DRAW_QUALITY_MID = 1;
  int mBackgroundColor = -16777216;
  SubScreenContainer mContainer;
  int mCurrentIndex;
  MSubScreenEffector mEffector;
  int mGap;
  int mOrientation;
  int mQuality;
  MSubScreenEffector[] mRandomEffectors;
  ScreenScroller mScroller;
  int mTopPadding;
  int mType;
  
  static
  {
    if (!SubScreenEffector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SubScreenEffector(ScreenScroller paramScreenScroller)
  {
    assert (paramScreenScroller != null);
    this.mScroller = paramScreenScroller;
    this.mScroller.setEffector(this);
  }
  
  public int getMaxOvershootPercent()
  {
    if (this.mEffector == null) {
      return 100;
    }
    return this.mEffector.getMaxOvershootPercent();
  }
  
  public void onAttach(ScreenScrollerListener paramScreenScrollerListener)
  {
    if ((paramScreenScrollerListener != null) && ((paramScreenScrollerListener instanceof SubScreenContainer)))
    {
      ScreenScroller localScreenScroller = paramScreenScrollerListener.getScreenScroller();
      this.mContainer = ((SubScreenContainer)paramScreenScrollerListener);
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
    throw new IllegalArgumentException("container is not an instance of SubScreenEffector.SubScreenContainer");
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
    int k = this.mGap * 2;
    int j = this.mScroller.getCurrentScreenOffset();
    int m = this.mScroller.getFirstVisiableScreenSize();
    if (j > 0) {}
    for (int i = j - m;; i = j)
    {
      int n = this.mTopPadding;
      int i1 = this.mScroller.getDrawingScreenA();
      int i2 = this.mScroller.getDrawingScreenB();
      if ((i == 0) && (this.mScroller.getCurrentDepth() == 0.0F))
      {
        MSubScreenEffector.drawView(this.mContainer, this.mScroller, paramCanvas, i1, i + k, n);
        return true;
      }
      if (this.mEffector == null)
      {
        MSubScreenEffector.drawView(this.mContainer, this.mScroller, paramCanvas, i1, i + k, n);
        MSubScreenEffector.drawView(this.mContainer, this.mScroller, paramCanvas, i2, i + k + m, n);
        return true;
      }
      this.mEffector.onScrollChanged(this.mScroller.getScroll() + k, j);
      if (this.mEffector.toReverse())
      {
        this.mEffector.drawView(paramCanvas, i2, i + m, n, false);
        this.mEffector.drawView(paramCanvas, i1, i, n, true);
        return true;
      }
      this.mEffector.drawView(paramCanvas, i1, i, n, true);
      this.mEffector.drawView(paramCanvas, i2, i + m, n, false);
      return true;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mOrientation = this.mScroller.getOrientation();
    if (this.mEffector != null) {
      this.mEffector.onSizeChanged();
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
 * Qualified Name:     com.tencent.qqmail.scroller.effector.SubScreenEffector
 * JD-Core Version:    0.7.0.1
 */