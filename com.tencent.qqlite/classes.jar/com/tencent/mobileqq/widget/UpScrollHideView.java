package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class UpScrollHideView
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = -1;
  private float jdField_a_of_type_Float;
  private UpScrollHideView.onViewHideListener jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = null;
  private int b = -1;
  private int c = 0;
  
  public UpScrollHideView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        this.b = paramMotionEvent.getPointerId(0);
        continue;
        int i = paramMotionEvent.findPointerIndex(this.b);
        if (i != -1)
        {
          float f = paramMotionEvent.getY(i);
          this.c = ((int)(this.jdField_a_of_type_Float - f));
          if (this.c > 0) {
            scrollTo(0, this.c);
          }
        }
      }
    }
    if (this.c > getHeight())
    {
      setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener.a();
      }
    }
    for (;;)
    {
      this.b = -1;
      break;
      scrollTo(0, 0);
    }
  }
  
  public void setOnViewHideListener(UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = paramonViewHideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UpScrollHideView
 * JD-Core Version:    0.7.0.1
 */