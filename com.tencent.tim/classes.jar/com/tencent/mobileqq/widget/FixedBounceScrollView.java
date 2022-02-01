package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class FixedBounceScrollView
  extends ScrollView
{
  private float Bh;
  private float Bi;
  private float Bj = -1.0F;
  private float Bk = -1.0F;
  private float Bl = -1.0F;
  private float Bm = -1.0F;
  private TranslateAnimation I;
  private b jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$b;
  private c jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$c;
  private long avx;
  private Rect cT = new Rect();
  private boolean dac;
  boolean dad = false;
  private int efK;
  private int efL;
  private int efM;
  private boolean isHorizontal;
  private View mChildView;
  private Interpolator mInterpolator;
  private int maxHeight;
  
  public FixedBounceScrollView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FixedBounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedBounceScrollView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setFillViewport(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qw, 0, 0);
    this.Bh = paramContext.getFloat(1, 4.0F);
    if (paramContext.getInt(3, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isHorizontal = bool;
      this.dac = paramContext.getBoolean(2, true);
      this.avx = paramContext.getInt(0, 400);
      this.efK = paramContext.getInt(4, 20);
      paramContext.recycle();
      if (this.dac) {
        this.mInterpolator = new a(null);
      }
      setmCustomBottomFadingEdgeScale(0.0F);
      setmCustomTopFadingEdgeScale(0.0F);
      return;
    }
  }
  
  private boolean aGt()
  {
    if (this.isHorizontal) {
      if (getScrollX() != 0) {}
    }
    while (getScrollY() == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean aGu()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.isHorizontal)
    {
      j = this.mChildView.getMeasuredWidth() - getWidth();
      i = j;
      if (j < 0) {
        i = 0;
      }
      bool1 = bool2;
      if (getScrollX() == i) {
        bool1 = true;
      }
      return bool1;
    }
    int j = this.mChildView.getMeasuredHeight() - getHeight();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (getScrollY() == i) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  private float bM()
  {
    if (this.isHorizontal) {}
    for (float f = Math.abs(this.mChildView.getLeft()) * 1.0F / this.mChildView.getMeasuredWidth();; f = Math.abs(this.mChildView.getTop()) * 1.0F / this.mChildView.getMeasuredHeight())
    {
      f = (float)(f + 0.2D);
      if (!this.dac) {
        break;
      }
      return this.Bh / (1.0F - (float)Math.pow(f, 2.0D));
    }
    return this.Bh;
  }
  
  private void ehS()
  {
    ViewGroup.LayoutParams localLayoutParams = this.mChildView.getLayoutParams();
    int i = 0;
    int j;
    int k;
    if (this.isHorizontal) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        j = ViewCompat.getPaddingEnd(this);
        i = j;
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          break label260;
        }
        k = ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      for (this.I = new TranslateAnimation(this.mChildView.getLeft() - i - j, this.cT.left - i - j, 0.0F, 0.0F);; this.I = new TranslateAnimation(0.0F, 0.0F, this.mChildView.getTop() - j - i, this.cT.top - j - i))
      {
        this.I.setInterpolator(this.mInterpolator);
        this.I.setDuration(this.avx);
        this.mChildView.startAnimation(this.I);
        this.mChildView.layout(this.cT.left, this.cT.top, this.cT.right, this.cT.bottom);
        this.cT.setEmpty();
        return;
        j = ViewCompat.getPaddingStart(this);
        i = j;
        if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          break label260;
        }
        k = ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin;
        i = j;
        j = k;
        break;
        j = getPaddingTop();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          i = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
        }
      }
      label260:
      j = 0;
    }
  }
  
  private boolean mH(int paramInt)
  {
    if ((paramInt != 0) && (paramInt < 0)) {
      return aGt();
    }
    return aGu();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return this.isHorizontal;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return !this.isHorizontal;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    if (this.Bk != -1.0F) {
      return this.Bk;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    if (this.Bl != -1.0F) {
      return this.Bl;
    }
    if (computeHorizontalScrollOffset() > 0) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    if (this.Bm != -1.0F) {
      return this.Bm;
    }
    if (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() < computeHorizontalScrollRange()) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    if (this.Bj != -1.0F) {
      return this.Bj;
    }
    int i = getVerticalFadingEdgeLength();
    if (getScrollY() < i) {
      return getScrollY() / i;
    }
    return 1.0F;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.I != null) && (!this.I.hasEnded())) {
      this.I.cancel();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() > 0) {
      this.mChildView = getChildAt(0);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.dad) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    label114:
    do
    {
      do
      {
        return bool;
        if (this.isHorizontal) {}
        for (float f = paramMotionEvent.getX();; f = paramMotionEvent.getY())
        {
          this.Bi = f;
          break;
        }
        if (!this.isHorizontal) {
          break label114;
        }
      } while (Math.abs(paramMotionEvent.getX() - this.Bi) >= this.efK);
      return false;
    } while (Math.abs(paramMotionEvent.getY() - this.Bi) >= this.efK);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    View localView;
    if (getChildCount() > 0)
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredHeight();
      if (paramInt2 > 0) {
        break label49;
      }
    }
    label49:
    int k;
    int i;
    int m;
    int j;
    do
    {
      ViewGroup.LayoutParams localLayoutParams;
      do
      {
        return;
        paramInt1 = localView.getMeasuredWidth();
        localLayoutParams = localView.getLayoutParams();
      } while (!(localLayoutParams instanceof FrameLayout.LayoutParams));
      k = ((FrameLayout.LayoutParams)localLayoutParams).leftMargin;
      i = ((FrameLayout.LayoutParams)localLayoutParams).topMargin;
      m = ((FrameLayout.LayoutParams)localLayoutParams).rightMargin;
      j = ((FrameLayout.LayoutParams)localLayoutParams).bottomMargin;
      if (QLog.isColorLevel()) {
        QLog.d("FixedBounceScrollView", 4, "marginStart=" + k + " topMargin=" + i + " marginEnd=" + m + " bottomMargin=" + j);
      }
    } while ((k == 0) && (i == 0) && (m == 0) && (j == 0));
    if (paramInt2 <= getMeasuredHeight())
    {
      paramInt1 -= m + k;
      paramInt2 -= j + i;
    }
    for (;;)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
      paramInt2 = i + j + paramInt2;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$c.ky(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.mChildView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    float f;
    label66:
    int j;
    int i;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      return super.onTouchEvent(paramMotionEvent);
    case 2: 
      if (this.isHorizontal)
      {
        f = paramMotionEvent.getX();
        j = (int)((this.Bi - f) / bM());
        this.Bi = f;
        setmCustomTopFadingEdgeScale(1.0F);
        setmCustomBottomFadingEdgeScale(1.0F);
        if ((this.efL > 0) || (j <= 0)) {
          break label411;
        }
        i = 0;
      }
      break;
    }
    for (;;)
    {
      label109:
      this.efL = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FixedBounceScrollView", 2, "dampingDelta=" + j);
        QLog.d("FixedBounceScrollView", 2, "mChildView.getTop()+mChildView.getPaddingTop()" + this.mChildView.getTop() + " " + this.mChildView.getPaddingTop());
        QLog.d("FixedBounceScrollView", 2, "mChildView.getBottom() + mChildView.getPaddingBottom()" + this.mChildView.getBottom() + " " + this.mChildView.getPaddingBottom());
      }
      if ((i == 0) || (!mH(j))) {
        break;
      }
      if (this.cT.isEmpty()) {
        this.cT.set(this.mChildView.getLeft(), this.mChildView.getTop(), this.mChildView.getRight(), this.mChildView.getBottom());
      }
      label353:
      b localb;
      if (this.isHorizontal)
      {
        this.mChildView.layout(this.mChildView.getLeft() - j, this.mChildView.getTop(), this.mChildView.getRight() - j, this.mChildView.getBottom());
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$b == null) {
          break;
        }
        this.efM += j;
        localb = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$b;
        if (this.efM > 0) {
          break label476;
        }
      }
      for (;;)
      {
        localb.bM(bool, Math.abs(this.efM));
        break;
        f = paramMotionEvent.getY();
        break label66;
        label411:
        if ((this.efL < 0) || (j >= 0)) {
          break label528;
        }
        i = 0;
        break label109;
        this.mChildView.layout(this.mChildView.getLeft(), this.mChildView.getTop() - j + 2, this.mChildView.getRight(), this.mChildView.getBottom() - j + 2);
        break label353;
        label476:
        bool = false;
      }
      setmCustomTopFadingEdgeScale(0.0F);
      setmCustomBottomFadingEdgeScale(0.0F);
      postInvalidate();
      performClick();
      if (!this.cT.isEmpty()) {
        ehS();
      }
      this.efL = 0;
      this.efM = 0;
      break;
      label528:
      i = 1;
    }
  }
  
  public void setBounceDelay(long paramLong)
  {
    if (paramLong >= 0L) {
      this.avx = paramLong;
    }
  }
  
  public void setBounceInterpolator(@NonNull Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setDamping(@FloatRange(from=0.0D, to=100.0D) float paramFloat)
  {
    if (this.Bh > 0.0F) {
      this.Bh = paramFloat;
    }
  }
  
  public void setIncrementalDamping(boolean paramBoolean)
  {
    this.dac = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setNeedDisallowIntercept(boolean paramBoolean)
  {
    this.dad = paramBoolean;
  }
  
  public void setOnOverScrollListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$b = paramb;
  }
  
  public void setOnScrollListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView$c = paramc;
  }
  
  public void setScrollHorizontally(boolean paramBoolean)
  {
    this.isHorizontal = paramBoolean;
  }
  
  public void setTriggerOverScrollThreshold(int paramInt)
  {
    if (paramInt >= 0) {
      this.efK = paramInt;
    }
  }
  
  public void setmCustomBottomFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.Bk = paramFloat;
  }
  
  public void setmCustomLeftFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.Bl = paramFloat;
  }
  
  public void setmCustomRightFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.Bm = paramFloat;
  }
  
  public void setmCustomTopFadingEdgeScale(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.Bj = paramFloat;
  }
  
  static class a
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return (float)(1.0D - Math.pow(1.0F - paramFloat, 4.0D));
    }
  }
  
  public static abstract interface b
  {
    public abstract void bM(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void ky(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FixedBounceScrollView
 * JD-Core Version:    0.7.0.1
 */