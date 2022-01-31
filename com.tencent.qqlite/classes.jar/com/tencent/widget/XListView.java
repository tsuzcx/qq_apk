package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class XListView
  extends ListView
{
  public static final int aH = 1;
  public static final int aI = 2;
  private int jdField_a_of_type_Int = 0;
  private OnSizeChangeListener jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
  private XListView.MotionEventInterceptor jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor;
  
  public XListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setEdgeEffectEnabled(false);
    this.aj = 2147483647;
  }
  
  private int a()
  {
    if (getContext().getResources().getDisplayMetrics().widthPixels > getContext().getResources().getDisplayMetrics().heightPixels) {
      return 1;
    }
    return 2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.dispatchTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = a();
    if (this.jdField_a_of_type_Int != i) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, bool, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void setMotionEventInterceptor(XListView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor = paramMotionEventInterceptor;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener = paramOnSizeChangeListener;
  }
  
  public void setOverScrollDistance(int paramInt)
  {
    this.aj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.XListView
 * JD-Core Version:    0.7.0.1
 */