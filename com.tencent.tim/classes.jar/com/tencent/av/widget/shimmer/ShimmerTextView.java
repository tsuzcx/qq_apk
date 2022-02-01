package com.tencent.av.widget.shimmer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import jmc;
import jmc.a;

public class ShimmerTextView
  extends TextView
{
  private jmc a;
  int mIndex = 0;
  
  public ShimmerTextView(Context paramContext)
  {
    super(paramContext);
    this.a = new jmc(this, getPaint(), null);
    this.a.setPrimaryColor(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new a());
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new jmc(this, getPaint(), paramAttributeSet);
    this.a.setPrimaryColor(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new a());
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new jmc(this, getPaint(), paramAttributeSet);
    this.a.setPrimaryColor(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new a());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setShimmering(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setShimmering(false);
  }
  
  @SuppressLint({"WrongCall", "DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    if (this.a != null) {
      this.a.onDraw();
    }
    super.onDraw(paramCanvas);
    if (xU()) {
      postDelayed(new onDrawRunnable(), 40L);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.onSizeChanged();
    }
  }
  
  public void setAnimationSetupCallback(jmc.a parama)
  {
    this.a.setAnimationSetupCallback(parama);
  }
  
  public void setGradientX(float paramFloat)
  {
    this.a.setGradientX(paramFloat);
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.a.setPrimaryColor(paramInt);
  }
  
  public void setReflectionColor(int paramInt)
  {
    this.a.setReflectionColor(paramInt);
  }
  
  public void setShimmering(boolean paramBoolean)
  {
    this.a.setShimmering(paramBoolean);
    super.postInvalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    if (this.a != null) {
      this.a.setPrimaryColor(getCurrentTextColor());
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    if (this.a != null) {
      this.a.setPrimaryColor(getCurrentTextColor());
    }
  }
  
  public boolean xU()
  {
    return this.a.xU();
  }
  
  class a
    extends AccessibilityDelegateCompat
  {
    a() {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setVisibleToUser(false);
    }
  }
  
  class onDrawRunnable
    implements Runnable
  {
    onDrawRunnable() {}
    
    public void run()
    {
      ShimmerTextView localShimmerTextView = ShimmerTextView.this;
      localShimmerTextView.mIndex += 1;
      if (ShimmerTextView.this.mIndex >= 50) {
        ShimmerTextView.this.mIndex = 0;
      }
      ShimmerTextView.this.setGradientX(ShimmerTextView.this.getWidth() * ShimmerTextView.this.mIndex / 50);
      ShimmerTextView.this.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView
 * JD-Core Version:    0.7.0.1
 */