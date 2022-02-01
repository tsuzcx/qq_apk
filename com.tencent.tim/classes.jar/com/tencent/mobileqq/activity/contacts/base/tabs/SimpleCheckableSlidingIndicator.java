package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import aurf;
import yzx;
import yzy;

public class SimpleCheckableSlidingIndicator
  extends SimpleSlidingIndicator
{
  public static int cca;
  public static int ccb = 1;
  public static int ccc = 2;
  public static int cce = 1;
  b a;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new yzy(this);
  private a jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a;
  private int ccd = -9999999;
  private aurf f;
  private int scrollType = cca;
  
  public SimpleCheckableSlidingIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String[] E()
  {
    return this.bD;
  }
  
  public int[] I()
  {
    return this.dw;
  }
  
  protected void aXq()
  {
    if (this.LB != this.currentPosition)
    {
      Object localObject = this.ek.getChildAt(this.LB);
      View localView = this.ek.getChildAt(this.currentPosition);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new yzx(this));
        ((ValueAnimator)localObject).start();
      }
      while (localView == null) {
        return;
      }
      this.aYV = localView.getLeft();
      invalidate();
      return;
    }
    this.aYV = this.ek.getChildAt(this.currentPosition).getLeft();
    invalidate();
  }
  
  protected void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.currentPosition != paramInt)
    {
      this.LB = this.currentPosition;
      this.currentPosition = paramInt;
      tB(paramInt);
      ET(this.currentPosition);
      if (paramBoolean1)
      {
        aXq();
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$b != null) && (paramInt >= 0)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$b.d(paramInt, paramBoolean2);
        }
      }
    }
    while ((this.currentPosition != paramInt) || (this.a == null) || (paramInt < 0)) {
      for (;;)
      {
        return;
        View localView = this.ek.getChildAt(this.currentPosition);
        if (localView != null) {
          this.aYV = localView.getLeft();
        }
        invalidate();
      }
    }
    this.a.Eu(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.scrollType = ccb;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a.yL(this.scrollType);
      }
      if (this.f != null)
      {
        this.f.removeMessages(cce);
        continue;
        if (this.f != null) {
          this.f.sendEmptyMessage(cce);
        }
      }
    }
  }
  
  public void setOnRepeatClickListener(b paramb)
  {
    this.a = paramb;
  }
  
  public void setScrollViewListener(a parama)
  {
    if (this.f == null) {
      this.f = new aurf(this.jdField_b_of_type_AndroidOsHandler$Callback);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void yL(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Eu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */