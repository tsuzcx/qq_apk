package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import atau.a;
import autc;

public class CirclePageIndicator
  extends View
  implements PageIndicator
{
  private float CA;
  private final Paint cS = new Paint(1);
  private final Paint cT = new Paint(1);
  private final Paint cU = new Paint(1);
  private int cuK;
  private boolean dkh;
  private boolean dki;
  private int esI;
  private int esJ;
  private ViewPager.OnPageChangeListener f;
  private int mActivePointerId = -1;
  private boolean mIsDragging;
  private float mLastMotionX = -1.0F;
  private int mOrientation;
  private float mRadius;
  private int mScrollState;
  private int mTouchSlop;
  private ViewPager mViewPager;
  
  public CirclePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034113);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    Object localObject = getResources();
    int i = ((Resources)localObject).getColor(2131165738);
    int j = ((Resources)localObject).getColor(2131165737);
    int k = ((Resources)localObject).getColor(2131165739);
    float f1 = ((Resources)localObject).getDimension(2131297088);
    float f2 = ((Resources)localObject).getDimension(2131297087);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pS, paramInt, 0);
    this.dkh = paramAttributeSet.getBoolean(2, true);
    this.mOrientation = paramAttributeSet.getInt(0, 0);
    this.cS.setStyle(Paint.Style.FILL);
    this.cS.setColor(paramAttributeSet.getColor(5, i));
    this.cT.setStyle(Paint.Style.STROKE);
    this.cT.setColor(paramAttributeSet.getColor(7, k));
    this.cT.setStrokeWidth(paramAttributeSet.getDimension(8, f1));
    this.cU.setStyle(Paint.Style.FILL);
    this.cU.setColor(paramAttributeSet.getColor(4, j));
    this.mRadius = paramAttributeSet.getDimension(3, f2);
    this.dki = paramAttributeSet.getBoolean(6, false);
    localObject = paramAttributeSet.getDrawable(1);
    if (localObject != null) {
      setBackgroundDrawable((Drawable)localObject);
    }
    paramAttributeSet.recycle();
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int le(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    if ((k == 1073741824) || (this.mViewPager == null)) {
      paramInt = i;
    }
    int j;
    do
    {
      return paramInt;
      paramInt = this.mViewPager.getAdapter().getCount();
      float f1 = getPaddingLeft() + getPaddingRight();
      float f2 = paramInt * 2;
      float f3 = this.mRadius;
      j = (int)((paramInt - 1) * this.mRadius + (f1 + f2 * f3) + 1.0F);
      paramInt = j;
    } while (k != -2147483648);
    return Math.min(j, i);
  }
  
  private int lf(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {
      return paramInt;
    }
    int j = (int)(2.0F * this.mRadius + getPaddingTop() + getPaddingBottom() + 1.0F);
    if (i == -2147483648) {
      return Math.min(j, paramInt);
    }
    return j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mViewPager == null) {}
    int n;
    do
    {
      return;
      n = this.mViewPager.getAdapter().getCount();
    } while (n == 0);
    if (this.cuK >= n)
    {
      setCurrentItem(n - 1);
      return;
    }
    int m;
    int k;
    int j;
    int i;
    float f2;
    float f1;
    label96:
    float f6;
    float f3;
    float f4;
    label197:
    float f5;
    if (this.mOrientation == 0)
    {
      m = getWidth();
      k = getPaddingLeft();
      j = getPaddingRight();
      i = getPaddingTop();
      f2 = this.mRadius;
      if (this.esJ != 0) {
        break label314;
      }
      f1 = this.mRadius;
      f6 = f2 * 2.0F + f1;
      f1 = i;
      f1 = this.mRadius + f1;
      f3 = k + this.mRadius;
      f2 = f3;
      if (this.dkh) {
        f2 = f3 + ((m - k - j) / 2.0F - n * f6 / 2.0F);
      }
      f4 = this.mRadius;
      f3 = f4;
      if (this.cT.getStrokeWidth() > 0.0F) {
        f3 = f4 - this.cT.getStrokeWidth() / 2.0F;
      }
      i = 0;
      if (i >= n) {
        break label329;
      }
      f4 = i * f6 + f2;
      if (this.mOrientation != 0) {
        break label323;
      }
      f5 = f4;
      f4 = f1;
    }
    for (;;)
    {
      if (this.cS.getAlpha() > 0) {
        paramCanvas.drawCircle(f5, f4, f3, this.cS);
      }
      if (f3 != this.mRadius) {
        paramCanvas.drawCircle(f5, f4, this.mRadius, this.cT);
      }
      i += 1;
      break label197;
      m = getHeight();
      k = getPaddingTop();
      j = getPaddingBottom();
      i = getPaddingLeft();
      break;
      label314:
      f1 = this.esJ;
      break label96;
      label323:
      f5 = f1;
    }
    label329:
    if (this.dki)
    {
      i = this.esI;
      f4 = i * f6;
      f3 = f4;
      if (!this.dki) {
        f3 = f4 + this.CA * f6;
      }
      if (this.mOrientation != 0) {
        break label415;
      }
      f3 = f2 + f3;
      f2 = f1;
      f1 = f3;
    }
    for (;;)
    {
      paramCanvas.drawCircle(f1, f2, this.mRadius, this.cU);
      return;
      i = this.cuK;
      break;
      label415:
      f2 += f3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 0)
    {
      setMeasuredDimension(le(paramInt1), lf(paramInt2));
      return;
    }
    setMeasuredDimension(lf(paramInt1), le(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.f != null) {
      this.f.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.cuK = paramInt1;
    this.CA = paramFloat;
    invalidate();
    if (this.f != null) {
      this.f.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.dki) || (this.mScrollState == 0))
    {
      this.cuK = paramInt;
      this.esI = paramInt;
      invalidate();
    }
    if (this.f != null) {
      this.f.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.cuK = paramParcelable.Ib;
    this.esI = paramParcelable.Ib;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Ib = this.cuK;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (super.onTouchEvent(paramMotionEvent)) {}
    label317:
    do
    {
      do
      {
        float f1;
        float f2;
        do
        {
          do
          {
            do
            {
              return true;
              if ((this.mViewPager == null) || (this.mViewPager.getAdapter().getCount() == 0)) {
                return false;
              }
              j = paramMotionEvent.getAction() & 0xFF;
              switch (j)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.mLastMotionX = paramMotionEvent.getX();
                return true;
              case 2: 
                f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
                f2 = f1 - this.mLastMotionX;
                if ((!this.mIsDragging) && (Math.abs(f2) > this.mTouchSlop)) {
                  this.mIsDragging = true;
                }
                break;
              }
            } while (!this.mIsDragging);
            this.mLastMotionX = f1;
          } while ((!this.mViewPager.isFakeDragging()) && (!this.mViewPager.beginFakeDrag()));
          this.mViewPager.fakeDragBy(f2);
          return true;
          if (this.mIsDragging) {
            break label317;
          }
          i = this.mViewPager.getAdapter().getCount();
          int k = getWidth();
          f1 = k / 2.0F;
          f2 = k / 6.0F;
          if ((this.cuK <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (j == 3);
        this.mViewPager.setCurrentItem(this.cuK - 1);
        return true;
        if ((this.cuK >= i - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (j == 3);
      this.mViewPager.setCurrentItem(this.cuK + 1);
      return true;
      this.mIsDragging = false;
      this.mActivePointerId = -1;
    } while (!this.mViewPager.isFakeDragging());
    this.mViewPager.endFakeDrag();
    return true;
    i = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
    this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
    return true;
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, j) == this.mActivePointerId)
    {
      if (j == 0) {
        i = 1;
      }
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
    }
    this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
    return true;
  }
  
  public void setCentered(boolean paramBoolean)
  {
    this.dkh = paramBoolean;
    invalidate();
  }
  
  public void setCirclePadding(int paramInt)
  {
    this.esJ = paramInt;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.mViewPager == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.mViewPager.setCurrentItem(paramInt);
    this.cuK = paramInt;
    invalidate();
  }
  
  public void setFillColor(int paramInt)
  {
    this.cU.setColor(paramInt);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }
    this.mOrientation = paramInt;
    requestLayout();
  }
  
  public void setPageColor(int paramInt)
  {
    this.cS.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    invalidate();
  }
  
  public void setSnap(boolean paramBoolean)
  {
    this.dki = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.cT.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.cT.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.mViewPager == paramViewPager) {
      return;
    }
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.mViewPager = paramViewPager;
    this.mViewPager.setOnPageChangeListener(this);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new autc();
    int Ib;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.Ib = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Ib);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.CirclePageIndicator
 * JD-Core Version:    0.7.0.1
 */