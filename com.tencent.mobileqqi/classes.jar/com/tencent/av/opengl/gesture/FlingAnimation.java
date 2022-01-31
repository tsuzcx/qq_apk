package com.tencent.av.opengl.gesture;

import com.tencent.av.opengl.QQGLGestureView;

public class FlingAnimation
  implements Animation
{
  private float jdField_a_of_type_Float;
  private FlingAnimationListener jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimationListener;
  private float b;
  private float c = 0.95F;
  private float d = 10.0F;
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(FlingAnimationListener paramFlingAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimationListener = paramFlingAnimationListener;
  }
  
  public boolean a(QQGLGestureView paramQQGLGestureView, long paramLong)
  {
    float f1 = (float)paramLong / 1000.0F;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.b;
    this.jdField_a_of_type_Float *= this.c;
    this.b *= this.c;
    if ((Math.abs(this.jdField_a_of_type_Float) > this.d) && (Math.abs(this.b) > this.d)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimationListener != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimationListener.a(f2 * f1, f3 * f1);
        if (!bool) {
          this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimationListener.a();
        }
      }
      return bool;
    }
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void c(float paramFloat)
  {
    this.c = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.FlingAnimation
 * JD-Core Version:    0.7.0.1
 */