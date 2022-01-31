package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qqlite.R.styleable;
import ezn;
import ezo;

public class UnderlinePageIndicator
  extends View
  implements PageIndicator
{
  private static final int jdField_a_of_type_Int = -1;
  private static final int jdField_b_of_type_Int = 30;
  private float jdField_a_of_type_Float;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  protected ViewPager a;
  public final Runnable a;
  public boolean a;
  private float jdField_b_of_type_Float = -1.0F;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  
  public UnderlinePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UnderlinePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772073);
  }
  
  public UnderlinePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new ezn(this);
    if (isInEditMode()) {
      return;
    }
    Object localObject = getResources();
    boolean bool = ((Resources)localObject).getBoolean(2131689472);
    int j = ((Resources)localObject).getInteger(2131558406);
    int k = ((Resources)localObject).getInteger(2131558407);
    int m = ((Resources)localObject).getColor(2131427435);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.y, paramInt, 0);
    setFades(paramAttributeSet.getBoolean(2, bool));
    setSelectedColor(paramAttributeSet.getColor(1, m));
    setFadeDelay(paramAttributeSet.getInteger(3, j));
    setFadeLength(paramAttributeSet.getInteger(4, k));
    localObject = paramAttributeSet.getDrawable(0);
    if (localObject != null) {
      setBackgroundDrawable((Drawable)localObject);
    }
    paramAttributeSet.recycle();
    this.h = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {}
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
    } while (j == 0);
    if (this.g >= j)
    {
      setCurrentItem(j - 1);
      return;
    }
    int k = getPaddingLeft();
    float f1 = (getWidth() - k - getPaddingRight()) / (j * 1.0F);
    float f2 = k + (this.g + this.jdField_a_of_type_Float) * f1;
    paramCanvas.drawRect(f2, getPaddingTop(), f2 + f1, getHeight() - getPaddingBottom(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.f = paramInt;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.g = paramInt1;
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 <= 0) {
        break label64;
      }
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    }
    for (;;)
    {
      invalidate();
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      return;
      label64:
      if (this.f != 1) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.c);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.f == 0)
    {
      this.g = paramInt;
      this.jdField_a_of_type_Float = 0.0F;
      invalidate();
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (UnderlinePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.g = paramParcelable.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    UnderlinePageIndicator.SavedState localSavedState = new UnderlinePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
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
              if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount() == 0)) {
                return false;
              }
              k = paramMotionEvent.getAction() & 0xFF;
              switch (k)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.jdField_b_of_type_Float = paramMotionEvent.getX();
                return true;
              case 2: 
                f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.i));
                f2 = f1 - this.jdField_b_of_type_Float;
                if ((!this.jdField_b_of_type_Boolean) && (Math.abs(f2) > this.h)) {
                  this.jdField_b_of_type_Boolean = true;
                }
                break;
              }
            } while (!this.jdField_b_of_type_Boolean);
            this.jdField_b_of_type_Float = f1;
          } while ((!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging()) && (!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.beginFakeDrag()));
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.fakeDragBy(f2);
          return true;
          if (this.jdField_b_of_type_Boolean) {
            break label317;
          }
          j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
          int m = getWidth();
          f1 = m / 2.0F;
          f2 = m / 6.0F;
          if ((this.g <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (k == 3);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.g - 1);
        return true;
        if ((this.g >= j - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (k == 3);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.g + 1);
      return true;
      this.jdField_b_of_type_Boolean = false;
      this.i = -1;
    } while (!this.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
    return true;
    j = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.jdField_b_of_type_Float = MotionEventCompat.getX(paramMotionEvent, j);
    this.i = MotionEventCompat.getPointerId(paramMotionEvent, j);
    return true;
    int k = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, k) == this.i)
    {
      if (k == 0) {
        j = 1;
      }
      this.i = MotionEventCompat.getPointerId(paramMotionEvent, j);
    }
    this.jdField_b_of_type_Float = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.i));
    return true;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    this.g = paramInt;
    invalidate();
  }
  
  public void setFadeDelay(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setFadeLength(int paramInt)
  {
    this.d = paramInt;
    this.e = (255 / (this.d / 30));
  }
  
  public void setFades(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    else
    {
      return;
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setSelectedColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == paramViewPager) {
      return;
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    invalidate();
    post(new ezo(this));
  }
  
  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnderlinePageIndicator
 * JD-Core Version:    0.7.0.1
 */