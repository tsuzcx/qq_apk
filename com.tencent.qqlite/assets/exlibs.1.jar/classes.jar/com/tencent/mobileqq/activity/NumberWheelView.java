package com.tencent.mobileqq.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;
import java.util.List;

public class NumberWheelView
  extends WheelView
  implements AdapterView.OnItemSelectedListener, VerticalGallery.OnEndFlingListener, VerticalGallery.OnEndMovementListener, VerticalGallery.OnSelectViewDataUpdateListener
{
  public static final int a = 0;
  public static final int b = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private NumberWheelView.NumberAdapter jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter;
  private NumberWheelView.ScrollStateListener jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener;
  public int c;
  private final int l = 0;
  private final int m = 30;
  private final int n = 20;
  private final int o = -7829368;
  private final int p = 5;
  private final int q = 1;
  private final int r = 23;
  private final int s = -16777216;
  private int t;
  private int u;
  
  public NumberWheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = 1;
    this.t = 0;
    this.u = 0;
    setNeedTranslate(true);
    setScrollCycle(true);
    setOnEndFlingListener(this);
    setOnEndMovementListener(this);
    setOnItemSelectedListener(this);
    setOnSelectViewDataUpdateListener(this);
  }
  
  private void b(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt != 0) {
        break label30;
      }
      ((WheelTextView)paramView).setTextSize(20.0F);
      ((WheelTextView)paramView).setTextColor(-7829368);
    }
    label30:
    while (paramInt != 1) {
      return;
    }
    ((WheelTextView)paramView).setTextSize(23.0F);
    ((WheelTextView)paramView).setTextColor(-16777216);
  }
  
  public int a()
  {
    int i = p();
    if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter.a.size())) {
      return 0;
    }
    return ((Integer)this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter.a.get(i)).intValue();
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramView, 1);
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    this.c = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener.a(paramVerticalGallery);
    }
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter.getCount();
    paramInt = 0;
    while (paramInt < i)
    {
      b(paramAdapterView.getChildAt(paramInt), 0);
      paramInt += 1;
    }
    b(paramView, 1);
  }
  
  public void b(VerticalGallery paramVerticalGallery)
  {
    this.c = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener.a(paramVerticalGallery);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.c = 0;
    }
    return bool;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.c = 0;
    }
    return bool;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.t = paramInt2;
      this.u = paramInt1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter = new NumberWheelView.NumberAdapter(this, this.jdField_a_of_type_AndroidContentContext, 30, this.t, this.u);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter);
      return;
      this.u = paramInt2;
      this.t = paramInt1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$NumberAdapter.a(paramInt1, paramInt2);
  }
  
  public void setScrollStateListener(NumberWheelView.ScrollStateListener paramScrollStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView$ScrollStateListener = paramScrollStateListener;
  }
  
  public void setValue(int paramInt)
  {
    if ((paramInt < this.t) || (paramInt > this.u)) {
      return;
    }
    setSelection(paramInt - this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NumberWheelView
 * JD-Core Version:    0.7.0.1
 */