package com.tencent.av.opengl.gesture;

import com.tencent.av.opengl.QQGLGestureView;

public class MoveAnimation
  implements Animation
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 100L;
  private MoveAnimationListener jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 0L;
  private float c;
  private float d;
  
  public float a()
  {
    return this.c;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(MoveAnimationListener paramMoveAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener = paramMoveAnimationListener;
  }
  
  public boolean a(QQGLGestureView paramQQGLGestureView, long paramLong)
  {
    boolean bool = false;
    this.jdField_b_of_type_Long += paramLong;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramQQGLGestureView.a();
      this.jdField_b_of_type_Float = paramQQGLGestureView.b();
    }
    if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)
    {
      f1 = (float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long;
      f2 = this.c;
      f3 = this.jdField_a_of_type_Float;
      f4 = this.jdField_a_of_type_Float;
      f5 = this.d;
      f6 = this.jdField_b_of_type_Float;
      f7 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener != null) {
        this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener.a((f2 - f3) * f1 + f4, f1 * (f5 - f6) + f7);
      }
      bool = true;
    }
    while (this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener == null)
    {
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimationListener.a(this.c, this.d);
    return false;
  }
  
  public float b()
  {
    return this.d;
  }
  
  public void b(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.MoveAnimation
 * JD-Core Version:    0.7.0.1
 */