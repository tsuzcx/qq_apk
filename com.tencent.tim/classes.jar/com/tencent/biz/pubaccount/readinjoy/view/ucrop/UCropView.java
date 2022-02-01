package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import atau.a;
import nqs;
import nqt;

public class UCropView
  extends FrameLayout
{
  private final OverlayView a;
  private GestureCropImageView b;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131560578, this, true);
    this.b = ((GestureCropImageView)findViewById(2131368942));
    this.a = ((OverlayView)findViewById(2131381925));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sA);
    this.a.b(paramContext);
    this.b.b(paramContext);
    paramContext.recycle();
    ban();
  }
  
  private void ban()
  {
    this.b.setCropBoundsChangeListener(new nqs(this));
    this.a.setOverlayViewChangeListener(new nqt(this));
  }
  
  @NonNull
  public GestureCropImageView a()
  {
    return this.b;
  }
  
  @NonNull
  public OverlayView a()
  {
    return this.a;
  }
  
  public void aPP()
  {
    removeView(this.b);
    this.b = new GestureCropImageView(getContext());
    ban();
    this.b.setCropRect(a().c());
    addView(this.b, 0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.UCropView
 * JD-Core Version:    0.7.0.1
 */