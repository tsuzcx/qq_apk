package com.tencent.mobileqq.location.ui;

import aiui;
import aiuj;
import aiuk;
import aiul;
import aium;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import ayrd;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class PoiSlideBottomPanel
  extends SlideBottomPanel
{
  private View Eh;
  private int dfi = 2;
  private View ef;
  
  public PoiSlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int FY()
  {
    return this.aDH;
  }
  
  public int FZ()
  {
    return this.dfi;
  }
  
  public boolean aj(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (System.currentTimeMillis() - this.aDf <= 500L) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      this.aDf = System.currentTimeMillis();
      this.Gf = paramMotionEvent.getX();
      float f = paramMotionEvent.getY();
      this.downY = f;
      this.Gg = f;
      paramMotionEvent = new Rect();
      this.ef.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (this.downY > paramMotionEvent.top)
      {
        bool1 = bool2;
        if (this.downY < paramMotionEvent.bottom) {
          bool1 = true;
        }
      }
      this.dAz = bool1;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. firstDownY: " + this.Gg + " actionRect: " + paramMotionEvent + " isConsume: " + bool1);
    return bool1;
  }
  
  public void displayPanel()
  {
    if ((this.dAy) || (this.isAnimating)) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      float f1 = localView.getY();
      float f2 = this.bSn;
      float f3 = this.Gi;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.bSn - this.Gi }).setDuration(this.mAnimationDuration);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setInterpolator(this.f);
      localValueAnimator.addUpdateListener(new aiuj(this, localView, f1, f2 - f3));
      localValueAnimator.addListener(new aiuk(this));
      localValueAnimator.start();
      this.dAy = true;
      this.isAtBottom = false;
    } while (this.a == null);
    this.a.displayPanel();
  }
  
  public void handleActionMove(MotionEvent paramMotionEvent)
  {
    if (!this.dAz) {}
    do
    {
      do
      {
        return;
        caU();
        if (this.Eh == null) {
          this.Eh = findViewWithTag(Integer.valueOf(1));
        }
        if ((!this.isDragging) && (Math.abs(paramMotionEvent.getY() - this.Gg) > this.mTouchSlop))
        {
          this.isDragging = true;
          this.downY = paramMotionEvent.getY();
          this.Eh.addOnLayoutChangeListener(new aiui(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. isDragging: " + this.isDragging + " Math.abs(event.getY() - firstDownY): " + Math.abs(paramMotionEvent.getY() - this.Gg) + " mTouchSlop: " + this.mTouchSlop);
        }
      } while (!this.isDragging);
      this.Gh = (paramMotionEvent.getY() - this.downY);
      this.downY = paramMotionEvent.getY();
      float f = this.Eh.getY();
      if ((this.a != null) && (f > this.bSn - this.Gi) && (f < this.bSn - this.Gj))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PoiSlideBottomPanel", 2, "[panel] fadeBackground: invoked. touchingViewY: " + f + " mMeasureHeight: " + this.bSn + " mPanelHeight: " + this.Gi + " mTitleHeightNoDisplay: " + this.Gj + " mMeasureHeight - mPanelHeight: " + (this.bSn - this.Gi) + " mMeasureHeight - mTitleHeightNoDisplay: " + (this.bSn - this.Gj));
        }
        this.a.fadeBackground(1.0F - f / (this.bSn - this.Gj));
      }
      if (this.Gh + f <= this.bSn - this.Gi)
      {
        this.Eh.offsetTopAndBottom((int)(this.bSn - this.Gi - f));
        return;
      }
      if (f + this.Gh < FY()) {
        break;
      }
    } while (this.isAtBottom);
    if (this.Gh > this.eMC) {
      this.Gh = this.eMC;
    }
    this.Eh.offsetTopAndBottom((int)this.Gh);
    return;
    this.Eh.offsetTopAndBottom((int)this.Gh);
  }
  
  public void handleActionUp(MotionEvent paramMotionEvent)
  {
    if (!this.dAz) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.aDf;
    caU();
    float f;
    if (((!this.dAy) && (paramMotionEvent.getY() - this.Gg < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.Gg) > this.Gk)) || ((this.Ge < 0.0F) && (Math.abs(this.Ge) > Math.abs(this.Gd)) && (Math.abs(this.Ge) > this.csM)))
    {
      displayPanel();
      if (this.dAy)
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        f = paramMotionEvent.getY();
        if ((f >= this.bSn - this.Gi) && (f >= this.bSn - this.Gi + this.Gk)) {
          break label436;
        }
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f, this.bSn - this.Gi }).setDuration(this.mAnimationDuration).start();
      }
    }
    for (;;)
    {
      this.dAz = false;
      this.isDragging = false;
      this.Gh = 0.0F;
      return;
      if ((l1 - l2 < 300L) && (c(this.Gf, this.Gg, paramMotionEvent.getX(), paramMotionEvent.getY()) < Gc + 5.0F))
      {
        if (this.dAy)
        {
          hidePanel();
          break;
        }
        displayPanel();
        this.dfi = 1;
        break;
      }
      if ((this.dAy) || (!this.isDragging)) {
        break;
      }
      int i = (int)(paramMotionEvent.getY() - this.Gg);
      if (((!this.isAtBottom) && (i > this.eMD)) || ((this.isAtBottom) && (i < 0) && (Math.abs(i) < this.Gk))) {
        eTr();
      }
      if ((this.isAtBottom) || (i >= 0) || (Math.abs(i) >= this.Gk)) {
        break;
      }
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.bSn - this.Gj }).setDuration(this.mAnimationDuration).start();
      break;
      label436:
      if (f > this.bSn - this.Gi + this.Gk) {
        hidePanel();
      }
    }
  }
  
  public void hidePanel()
  {
    if (this.isAnimating) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      int i = (int)(this.bSn - this.Gj);
      float f = localView.getY();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.bSn - this.Gj });
      localValueAnimator.setInterpolator(this.g);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setDuration(500L);
      localValueAnimator.addUpdateListener(new aiul(this, localView, f, i));
      localValueAnimator.addListener(new aium(this));
      localValueAnimator.start();
    } while (this.a == null);
    this.a.hidePanel();
  }
  
  public void setBottomHeight(int paramInt)
  {
    this.aDH = paramInt;
  }
  
  public void setDisplayFromType(int paramInt)
  {
    this.dfi = paramInt;
  }
  
  public void setDragView(View paramView)
  {
    this.ef = paramView;
  }
  
  public void setTitleHeightNoDisplay(int paramInt)
  {
    this.Gj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */