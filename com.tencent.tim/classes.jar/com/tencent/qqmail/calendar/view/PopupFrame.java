package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

public class PopupFrame
  extends FrameLayout
{
  private boolean hasShowed = false;
  private boolean isAnimationEnd = false;
  private IPopupContent mContentView;
  private boolean mFirstLayout = true;
  private ViewGroup mParentView;
  
  public PopupFrame(Context paramContext, ViewGroup paramViewGroup, IPopupContent paramIPopupContent)
  {
    super(paramContext);
    this.mParentView = paramViewGroup;
    this.mContentView = paramIPopupContent;
    if ((this.mContentView instanceof View))
    {
      addView((View)this.mContentView);
      this.mContentView.setPopupFrame(this);
      setBackgroundColor(-1593835520);
      return;
    }
    throw new IllegalArgumentException("ContentView must extends View");
  }
  
  public void dismiss()
  {
    this.hasShowed = false;
    this.isAnimationEnd = false;
    setBackgroundColor(0);
    this.mContentView.onPopupFrameDismiss(true, new PopupFrame.1(this));
  }
  
  public IPopupContent getContentView()
  {
    return this.mContentView;
  }
  
  public boolean hasShow()
  {
    return this.hasShowed;
  }
  
  public void onBackPressed()
  {
    this.mContentView.onBackPressed();
    dismiss();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.isAnimationEnd)
    {
      boolean bool1;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        return bool1;
      }
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = getChildCount();
      paramMotionEvent = new Rect();
      int i = 0;
      for (;;)
      {
        if (i >= m) {
          break label107;
        }
        getChildAt(i).getHitRect(paramMotionEvent);
        bool1 = bool2;
        if (paramMotionEvent.contains(j, k)) {
          break;
        }
        i += 1;
      }
      label107:
      return true;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    if ((paramBoolean) || (this.mFirstLayout))
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.mFirstLayout = false;
    }
    for (;;)
    {
      return;
      paramInt2 = getChildCount();
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        View localView = getChildAt(paramInt1);
        if ((localView.getVisibility() != 8) && (localView.isLayoutRequested())) {
          localView.layout(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.isAnimationEnd) {}
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = super.onTouchEvent(paramMotionEvent);
      return bool1;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int m = getChildCount();
    paramMotionEvent = new Rect();
    int i = 0;
    for (;;)
    {
      if (i >= m) {
        break label107;
      }
      getChildAt(i).getHitRect(paramMotionEvent);
      bool1 = bool2;
      if (paramMotionEvent.contains(j, k)) {
        break;
      }
      i += 1;
    }
    label107:
    this.mContentView.onTouchContentOutRect();
    dismiss();
    return true;
  }
  
  public void show()
  {
    if (!this.hasShowed)
    {
      if (getParent() == null) {
        this.mParentView.addView(this);
      }
      this.isAnimationEnd = false;
      this.hasShowed = true;
      this.mContentView.onPopupFrameShow(true, new PopupFrame.2(this));
      setVisibility(0);
    }
  }
  
  public static abstract interface IPopupContent
  {
    public abstract void onBackPressed();
    
    public abstract void onPopupFrameDismiss(boolean paramBoolean, Animation.AnimationListener paramAnimationListener);
    
    public abstract void onPopupFrameShow(boolean paramBoolean, Animation.AnimationListener paramAnimationListener);
    
    public abstract void onTouchContentOutRect();
    
    public abstract void setPopupFrame(PopupFrame paramPopupFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.PopupFrame
 * JD-Core Version:    0.7.0.1
 */