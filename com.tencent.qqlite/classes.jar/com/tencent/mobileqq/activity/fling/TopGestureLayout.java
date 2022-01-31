package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import cej;

public class TopGestureLayout
  extends RelativeLayout
{
  private static final int b = 0;
  private static final int c = -1;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 4;
  private static final int g = 8;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private TopGestureLayout.OnGestureListener jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout$OnGestureListener;
  private boolean jdField_a_of_type_Boolean = true;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new cej(this, paramContext));
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  private boolean a(int paramInt)
  {
    return (!b()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      return true;
    }
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnFlingGesture(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout$OnGestureListener = paramOnGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout
 * JD-Core Version:    0.7.0.1
 */