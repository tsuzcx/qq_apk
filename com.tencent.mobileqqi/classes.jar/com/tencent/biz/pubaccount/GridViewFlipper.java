package com.tencent.biz.pubaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ViewFlipper;
import bjz;
import com.tencent.qphone.base.util.QLog;

public class GridViewFlipper
  extends ViewFlipper
{
  private static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = "ViewFlipperTest";
  private static final int b = 0;
  private static final int c = 1;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private bjz jdField_a_of_type_Bjz;
  private int d = 0;
  
  public GridViewFlipper(Context paramContext)
  {
    super(paramContext);
  }
  
  public GridViewFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.d != 0)
    {
      return true;
      if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
      {
        float f1 = Math.abs((int)paramMotionEvent.getX() - this.jdField_a_of_type_AndroidViewMotionEvent.getX());
        float f2 = Math.abs((int)paramMotionEvent.getY() - this.jdField_a_of_type_AndroidViewMotionEvent.getY());
        if ((f1 >= 10.0F) || (f2 >= 10.0F))
        {
          QLog.d("ViewFlipperTest", 2, "======need move========");
          this.d = 1;
          if (this.jdField_a_of_type_Bjz != null) {
            this.jdField_a_of_type_Bjz.a(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent);
          }
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          continue;
          this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          this.d = 0;
          continue;
          this.d = 0;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
    }
    return false;
  }
  
  public void setOnScrollListener(bjz parambjz)
  {
    this.jdField_a_of_type_Bjz = parambjz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.GridViewFlipper
 * JD-Core Version:    0.7.0.1
 */