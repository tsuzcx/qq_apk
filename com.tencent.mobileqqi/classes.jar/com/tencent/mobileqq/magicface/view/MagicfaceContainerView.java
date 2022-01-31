package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import gfd;

public class MagicfaceContainerView
  extends RelativeLayout
{
  public static final int a = 150;
  private GestureDetector.SimpleOnGestureListener jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new gfd(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  private MagicfaceContainerView.MagicfaceGestureListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView$MagicfaceGestureListener;
  
  public MagicfaceContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setMagicfaceGestureListener(MagicfaceContainerView.MagicfaceGestureListener paramMagicfaceGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView$MagicfaceGestureListener = paramMagicfaceGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceContainerView
 * JD-Core Version:    0.7.0.1
 */