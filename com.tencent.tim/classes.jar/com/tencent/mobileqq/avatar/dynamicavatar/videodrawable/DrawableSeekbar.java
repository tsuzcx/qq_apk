package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DrawableSeekbar
  extends LinearLayout
  implements View.OnTouchListener
{
  a a;
  boolean bRu = false;
  int lastX;
  int lastY;
  ImageView mImageView;
  int max;
  int progress;
  int thumbHeight;
  int thumbOffset;
  int thumbWidth;
  int touchSlop;
  
  public DrawableSeekbar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DrawableSeekbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.touchSlop = ((int)(2.0F * getResources().getDisplayMetrics().density));
    this.mImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.mImageView, localLayoutParams);
    this.mImageView.setClickable(true);
    this.mImageView.setOnTouchListener(this);
    this.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mImageView.setContentDescription(acfp.m(2131705311));
  }
  
  private void layoutHorizontal()
  {
    if (this.thumbOffset != 0)
    {
      int j = this.thumbOffset;
      i = j;
      if (this.mImageView.getWidth() + j > getWidth()) {
        i = getWidth() - this.mImageView.getWidth();
      }
      this.mImageView.layout(i, 0, this.mImageView.getMeasuredWidth() + i, this.mImageView.getMeasuredHeight());
      return;
    }
    if ((this.progress == 0) || (this.max == 0)) {}
    for (int i = 0;; i = (int)(this.progress * (getMeasuredWidth() - this.mImageView.getMeasuredWidth()) / this.max))
    {
      this.mImageView.layout(i, 0, this.mImageView.getMeasuredWidth() + i, this.mImageView.getMeasuredHeight());
      return;
    }
  }
  
  public boolean isEnable()
  {
    return this.max > 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!isEnable()) {
      return false;
    }
    int k;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        return true;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.lastX = ((int)paramMotionEvent.getRawX());
        this.lastY = ((int)paramMotionEvent.getRawY());
        if (this.a != null) {
          this.a.bZJ();
        }
      }
    case 2: 
      k = (int)paramMotionEvent.getRawX() - this.lastX;
      if (Math.abs(k) < this.touchSlop) {
        return true;
      }
      this.thumbOffset = 0;
      i = paramView.getLeft() + k;
      k += paramView.getRight();
      if (i >= 0) {
        break;
      }
    }
    for (int i = paramView.getWidth() + 0;; i = k)
    {
      k = i;
      if (i > getWidth())
      {
        k = getWidth();
        j = k - paramView.getWidth();
      }
      if (this.a != null)
      {
        i = this.progress;
        this.progress = ((int)(j / (getWidth() - paramView.getWidth()) * this.max));
        if (i != this.progress) {
          this.a.Ce(this.progress);
        }
      }
      paramView.layout(j, paramView.getTop(), k, paramView.getBottom());
      paramView.invalidate();
      this.lastX = ((int)paramMotionEvent.getRawX());
      this.lastY = ((int)paramMotionEvent.getRawY());
      break;
      getParent().requestDisallowInterceptTouchEvent(false);
      this.bRu = false;
      if (this.a == null) {
        break;
      }
      this.a.cUO();
      break;
      j = i;
    }
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt != this.progress)
    {
      this.progress = paramInt;
      requestLayout();
    }
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    this.mImageView.setImageDrawable(paramDrawable);
  }
  
  public void setThumbOffset(int paramInt)
  {
    this.progress = 0;
    if (this.thumbOffset != paramInt) {
      this.thumbOffset = paramInt;
    }
    requestLayout();
  }
  
  public void setThumbSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.thumbWidth) || (paramInt2 != this.thumbHeight))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mImageView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.mImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ce(int paramInt);
    
    public abstract void bZJ();
    
    public abstract void cUO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar
 * JD-Core Version:    0.7.0.1
 */