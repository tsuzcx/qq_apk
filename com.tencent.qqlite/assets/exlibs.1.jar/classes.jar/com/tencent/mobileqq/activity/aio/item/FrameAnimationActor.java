package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import but;

public class FrameAnimationActor
{
  public int a;
  public View a;
  public FrameAnimationActor.Listener a;
  private Runnable a;
  public int[] a;
  public int b = 0;
  public int c = 0;
  
  public FrameAnimationActor(View paramView, int[] paramArrayOfInt, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRunnable = new but(this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.c = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Int = ((int)(paramLong / this.c));
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]);
      this.jdField_a_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[this.b]);
  }
  
  public void a(FrameAnimationActor.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor
 * JD-Core Version:    0.7.0.1
 */