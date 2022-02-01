package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import uhu;

public class MultilScreenlLayout
  extends FrameLayout
{
  protected a a;
  private uhu a;
  private int aYl = 1;
  private boolean bFJ;
  private int csM = 600;
  private int csN;
  private int csO;
  private int csP;
  private int csQ;
  private int cst;
  private int frameWidth;
  private float jM;
  private float jN;
  private int mCurScreen;
  private int mDefaultScreen;
  private int mFrameHeight;
  private float mLastMotionX;
  private int mTouchSlop;
  private int mTouchState = 0;
  private VelocityTracker mVelocityTracker;
  
  public MultilScreenlLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MultilScreenlLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private int getFrameWith()
  {
    if (this.frameWidth == 0) {
      return getWidth();
    }
    return this.frameWidth + this.csN;
  }
  
  private void init()
  {
    this.jdField_a_of_type_Uhu = new uhu(getContext());
    this.mCurScreen = this.mDefaultScreen;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.csM = (localViewConfiguration.getScaledMinimumFlingVelocity() * 2);
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_Uhu.computeScrollOffset())
    {
      super.scrollTo(this.jdField_a_of_type_Uhu.getCurrX(), this.jdField_a_of_type_Uhu.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mTouchState != 0)) {
      return true;
    }
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    default: 
      label60:
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder().append("onInterceptTouchEvent mTouchState != TOUCH_STATE_REST ");
        if (this.mTouchState == 0) {
          break label176;
        }
      }
      break;
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MutilScreenlLayout", 2, bool);
      if (this.mTouchState != 0) {
        break;
      }
      return false;
      if ((int)Math.abs(this.mLastMotionX - f) <= this.mTouchSlop) {
        break label60;
      }
      this.mTouchState = 1;
      break label60;
      this.mLastMotionX = f;
      if (this.jdField_a_of_type_Uhu.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.mTouchState = i;
        break;
      }
      this.mTouchState = 0;
      break label60;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.aYl == 1)
    {
      paramInt1 = this.cst;
      paramInt2 = this.csN;
      paramInt4 = super.getChildCount();
      paramInt2 += paramInt1;
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        View localView = super.getChildAt(paramInt1);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = getFrameWith();
          localView.layout(paramInt2, this.csQ, this.frameWidth + paramInt2, this.csQ + this.mFrameHeight);
          paramInt3 = paramInt2 + paramInt3;
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
      this.csP = (paramInt2 + this.csO - super.getWidth());
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (this.aYl == 0) {
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      for (;;)
      {
        label84:
        if (QLog.isColorLevel())
        {
          QLog.d("MutilScreenlLayout", 2, "onTouchEvent ");
          return true;
          if (!this.jdField_a_of_type_Uhu.isFinished()) {
            this.jdField_a_of_type_Uhu.abortAnimation();
          }
          this.mLastMotionX = f1;
          this.jN = f1;
          this.jM = f2;
          this.bFJ = false;
          continue;
          j = (int)(this.mLastMotionX - f1);
          this.mLastMotionX = f1;
          int k = super.getScrollX();
          i = j;
          if (k + j <= 0) {
            i = -k;
          }
          j = i;
          if (k + i >= this.csP) {
            j = this.csP - k;
          }
          if (j != 0) {
            scrollBy(j, 0);
          }
          if (Math.hypot(Math.abs(this.jN - f1), Math.abs(this.jM - f2)) > this.mTouchSlop)
          {
            this.bFJ = true;
            continue;
            paramMotionEvent = this.mVelocityTracker;
            paramMotionEvent.computeCurrentVelocity(1000);
            i = (int)paramMotionEvent.getXVelocity();
            if ((i > this.csM) && (this.mCurScreen > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX > mMinVelocity mCurScreen:" + this.mCurScreen + " velocityX:" + i);
              }
              snapToScreen(this.mCurScreen - 1);
              label343:
              if (this.mVelocityTracker != null)
              {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
              }
              this.mTouchState = 0;
              if (Math.hypot(Math.abs(this.jN - f1), Math.abs(this.jM - f2)) > this.mTouchSlop) {
                this.bFJ = true;
              }
              if ((this.bFJ) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$a == null)) {
                continue;
              }
              k = super.getChildCount();
              i = j;
              if (this.mCurScreen >= 0)
              {
                i = j;
                if (this.mCurScreen < k)
                {
                  paramMotionEvent = super.getChildAt(this.mCurScreen);
                  i = paramMotionEvent.getLeft() - super.getScrollX();
                  if ((f1 >= i) || (f1 <= i - this.csN)) {
                    break label755;
                  }
                }
              }
            }
          }
        }
      }
    }
    label755:
    for (i = 1;; i = 0)
    {
      j = paramMotionEvent.getRight() - super.getScrollX();
      if ((i == 0) && (f1 > j) && (f1 < j + this.csN)) {
        i = 1;
      }
      for (;;)
      {
        j = i;
        if (i == 0)
        {
          j = i;
          if (f1 < this.cst - super.getScrollX()) {
            j = 1;
          }
        }
        i = j;
        if (j == 0)
        {
          i = j;
          if (f1 > this.csP + super.getWidth() - super.getScrollX() - this.cst) {
            i = 1;
          }
        }
        if (i == 0) {
          break label84;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$a.N(f1, f2);
        break label84;
        if ((i < -this.csM) && (this.mCurScreen < super.getChildCount() - 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX < -mMinVelocity mCurScreen:" + this.mCurScreen + " velocityX:" + i);
          }
          snapToScreen(this.mCurScreen + 1);
          break label343;
        }
        snapToDestination();
        if (!QLog.isColorLevel()) {
          break label343;
        }
        QLog.d("MutilScreenlLayout", 2, "onTouchEvent velocityX:" + i);
        break label343;
        this.mTouchState = 0;
        break label84;
        break;
      }
    }
  }
  
  public void setClickLayoutListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$a = parama;
  }
  
  public void setCurrentFrame(int paramInt)
  {
    this.mCurScreen = paramInt;
    super.scrollTo(getFrameWith() * paramInt, 0);
  }
  
  public void setFrameWidth(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.frameWidth = paramInt1;
    this.csN = paramInt4;
    this.cst = paramInt5;
    this.csO = paramInt6;
    this.mFrameHeight = paramInt2;
    this.csQ = paramInt3;
  }
  
  public void setLayoutStyle(int paramInt)
  {
    if (this.aYl != paramInt)
    {
      this.aYl = paramInt;
      requestLayout();
    }
  }
  
  public void snapToDestination()
  {
    snapToScreen((getScrollX() + getFrameWith() / 2) / getFrameWith());
  }
  
  public void snapToScreen(int paramInt)
  {
    int i = 300;
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "snapToScreen before change whichScreen:" + paramInt);
    }
    int j = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    paramInt = getFrameWith() * j;
    if (QLog.isColorLevel()) {
      QLog.d("MutilScreenlLayout", 2, "snapToScreen dest:" + paramInt + " getScrollX():" + getScrollX() + " afterchange whichScreen:" + j);
    }
    int k;
    if (getScrollX() != paramInt)
    {
      k = paramInt - getScrollX();
      paramInt = Math.abs(k) / 2;
      if (paramInt >= 300) {
        break label172;
      }
      paramInt = i;
    }
    label172:
    for (;;)
    {
      this.jdField_a_of_type_Uhu.startScroll(getScrollX(), 0, k, 0, paramInt);
      this.mCurScreen = j;
      invalidate();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void N(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultilScreenlLayout
 * JD-Core Version:    0.7.0.1
 */