package com.tencent.av.opengl.gesture;

import android.graphics.PointF;
import com.tencent.av.opengl.QQGLGestureView;

public class ZoomAnimation
  implements Animation
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 200L;
  private ZoomAnimationListener jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 0L;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  public float a()
  {
    return this.c;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ZoomAnimationListener a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener;
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
  
  public void a(ZoomAnimationListener paramZoomAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener = paramZoomAnimationListener;
  }
  
  public boolean a(QQGLGestureView paramQQGLGestureView, long paramLong)
  {
    boolean bool = false;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.d = paramQQGLGestureView.a();
      this.e = paramQQGLGestureView.b();
      this.f = paramQQGLGestureView.c();
      this.i = (this.c * this.f - this.f);
      if (this.i > 0.0F)
      {
        paramQQGLGestureView = new VectorF();
        paramQQGLGestureView.a(new PointF(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float));
        paramQQGLGestureView.b(new PointF(this.d, this.e));
        paramQQGLGestureView.b();
        paramQQGLGestureView.jdField_b_of_type_Float = (paramQQGLGestureView.a() * this.c);
        paramQQGLGestureView.a();
        this.g = (paramQQGLGestureView.jdField_b_of_type_AndroidGraphicsPointF.x - this.d);
        this.h = (paramQQGLGestureView.jdField_b_of_type_AndroidGraphicsPointF.y - this.e);
      }
    }
    else
    {
      this.jdField_b_of_type_Long += paramLong;
      f1 = (float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long;
      if (f1 >= 1.0F) {
        break label314;
      }
      if (f1 > 0.0F)
      {
        f2 = this.i;
        f3 = this.f;
        f4 = this.g;
        f5 = this.d;
        f6 = this.h;
        float f7 = this.e;
        if (this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener != null) {
          this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener.a(f2 * f1 + f3, f4 * f1 + f5, f1 * f6 + f7);
        }
      }
      bool = true;
    }
    label314:
    do
    {
      return bool;
      this.g = (paramQQGLGestureView.d() - this.d);
      this.h = (paramQQGLGestureView.e() - this.e);
      break;
      f1 = this.i;
      f2 = this.f;
      f3 = this.g;
      f4 = this.d;
      f5 = this.h;
      f6 = this.e;
    } while (this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener == null);
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener.a(f1 + f2, f3 + f4, f5 + f6);
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimationListener.a();
    return false;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public float c()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void c(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.ZoomAnimation
 * JD-Core Version:    0.7.0.1
 */