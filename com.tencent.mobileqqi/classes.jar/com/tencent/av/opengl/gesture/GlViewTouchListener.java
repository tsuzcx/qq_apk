package com.tencent.av.opengl.gesture;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import bic;
import bid;
import bie;
import bif;
import com.tencent.av.opengl.QQGLGestureView;

public class GlViewTouchListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  public final PointF a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public View.OnClickListener a;
  QQGLGestureView jdField_a_of_type_ComTencentAvOpenglQQGLGestureView;
  FlingAnimation jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation;
  FlingListener jdField_a_of_type_ComTencentAvOpenglGestureFlingListener;
  MoveAnimation jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimation;
  final VectorF jdField_a_of_type_ComTencentAvOpenglGestureVectorF = new VectorF();
  ZoomAnimation jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 1.0F;
  int jdField_b_of_type_Int = 0;
  final PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  final VectorF jdField_b_of_type_ComTencentAvOpenglGestureVectorF = new VectorF();
  public boolean b;
  float jdField_c_of_type_Float = 1.0F;
  int jdField_c_of_type_Int;
  final PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float = 0.0F;
  int jdField_d_of_type_Int;
  final PointF jdField_d_of_type_AndroidGraphicsPointF = new PointF();
  boolean jdField_d_of_type_Boolean = false;
  float jdField_e_of_type_Float = 0.0F;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  float jdField_f_of_type_Float = 0.0F;
  int jdField_f_of_type_Int;
  float g = 0.0F;
  public float h = 4.0F;
  public float i = 0.25F;
  float j = 1.0F;
  float k = 1.0F;
  float l = 0.0F;
  float m = 0.0F;
  float n = 0.0F;
  
  public GlViewTouchListener(QQGLGestureView paramQQGLGestureView, int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView = paramQQGLGestureView;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.l = (paramInt1 / 2.0F);
    this.m = (paramInt2 / 2.0F);
    this.jdField_e_of_type_Int = paramQQGLGestureView.a();
    this.jdField_f_of_type_Int = paramQQGLGestureView.b();
    this.n = paramFloat;
    this.jdField_c_of_type_Float = this.n;
    this.jdField_b_of_type_Float = this.n;
    this.jdField_f_of_type_Float = paramInt1;
    this.g = paramInt2;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_c_of_type_AndroidGraphicsPointF.x = this.l;
    this.jdField_c_of_type_AndroidGraphicsPointF.y = this.m;
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingListener = new FlingListener();
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation = new FlingAnimation();
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation = new ZoomAnimation();
    this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimation = new MoveAnimation();
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation.a(new bic(this));
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.a(2.0F);
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.a(new bid(this));
    this.jdField_a_of_type_ComTencentAvOpenglGestureMoveAnimation.a(new bie(this, paramQQGLGestureView));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramQQGLGestureView.getContext(), new bif(this, paramQQGLGestureView));
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(paramQQGLGestureView.getContext(), this.jdField_a_of_type_ComTencentAvOpenglGestureFlingListener);
    f();
  }
  
  public float a()
  {
    return this.h;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation.a(this.jdField_a_of_type_ComTencentAvOpenglGestureFlingListener.a());
    this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation.b(this.jdField_a_of_type_ComTencentAvOpenglGestureFlingListener.b());
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a(this.jdField_a_of_type_ComTencentAvOpenglGestureFlingAnimation);
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    if (this.jdField_c_of_type_Float > this.h) {
      this.jdField_c_of_type_Float = this.h;
    }
    for (;;)
    {
      f();
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setScale(this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setPosition(this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_c_of_type_AndroidGraphicsPointF.y);
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
      return;
      if (this.jdField_c_of_type_Float < this.i)
      {
        this.jdField_c_of_type_Float = this.i;
      }
      else
      {
        this.jdField_c_of_type_AndroidGraphicsPointF.x = paramFloat2;
        this.jdField_c_of_type_AndroidGraphicsPointF.y = paramFloat3;
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.a();
    float f1;
    if (this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a()) {
      if (this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.d() < this.jdField_b_of_type_Int)
      {
        f1 = this.k / this.jdField_c_of_type_Float;
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.b(paramMotionEvent.getX());
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.c(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.e());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.a(f1);
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a(this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation);
      return;
      f1 = this.j / this.jdField_c_of_type_Float;
      this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.b(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.d());
      this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.c(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.e());
      continue;
      int i1 = this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.d();
      if (i1 == this.jdField_b_of_type_Int)
      {
        f1 = this.jdField_c_of_type_Float * 4.0F;
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.b(paramMotionEvent.getX());
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.c(paramMotionEvent.getY());
      }
      else if (i1 < this.jdField_b_of_type_Int)
      {
        f1 = this.k / this.jdField_c_of_type_Float;
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.b(paramMotionEvent.getX());
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.c(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.e());
      }
      else
      {
        f1 = this.k / this.jdField_c_of_type_Float;
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.b(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.d());
        this.jdField_a_of_type_ComTencentAvOpenglGestureZoomAnimation.c(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.e());
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
    paramFloat1 = this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_b_of_type_AndroidGraphicsPointF.x;
    paramFloat2 = this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_b_of_type_AndroidGraphicsPointF.y;
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      PointF localPointF;
      if (this.jdField_c_of_type_Boolean)
      {
        localPointF = this.jdField_c_of_type_AndroidGraphicsPointF;
        localPointF.x = (paramFloat1 + localPointF.x);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localPointF = this.jdField_c_of_type_AndroidGraphicsPointF;
        localPointF.y = (paramFloat2 + localPointF.y);
      }
      e();
      this.jdField_b_of_type_AndroidGraphicsPointF.x = this.jdField_a_of_type_AndroidGraphicsPointF.x;
      this.jdField_b_of_type_AndroidGraphicsPointF.y = this.jdField_a_of_type_AndroidGraphicsPointF.y;
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setPosition(this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_c_of_type_AndroidGraphicsPointF.y);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent)))
    {
      if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_b_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
        a();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label55;
      }
      c();
    }
    label55:
    label317:
    do
    {
      float f1;
      do
      {
        do
        {
          do
          {
            return true;
            if (paramMotionEvent.getAction() == 0)
            {
              b();
              this.jdField_b_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX();
              this.jdField_b_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY();
              this.jdField_a_of_type_Boolean = true;
              return true;
            }
          } while (paramMotionEvent.getAction() != 2);
          if (paramMotionEvent.getPointerCount() <= 1) {
            break label317;
          }
          this.jdField_e_of_type_Boolean = true;
          if (this.jdField_a_of_type_Float <= 0.0F) {
            break;
          }
          this.jdField_b_of_type_ComTencentAvOpenglGestureVectorF.a(paramMotionEvent);
          this.jdField_b_of_type_ComTencentAvOpenglGestureVectorF.a();
          f1 = this.jdField_b_of_type_ComTencentAvOpenglGestureVectorF.jdField_b_of_type_Float;
        } while (this.jdField_a_of_type_Float == f1);
        f1 = f1 / this.jdField_a_of_type_Float * this.jdField_b_of_type_Float;
      } while (f1 > this.h);
      paramView = this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF;
      paramView.jdField_b_of_type_Float *= f1;
      this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.a();
      paramView = this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF;
      paramView.jdField_b_of_type_Float /= f1;
      a(f1, this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.jdField_b_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.jdField_b_of_type_AndroidGraphicsPointF.y);
      return true;
      this.jdField_a_of_type_Float = MathUtils.a(paramMotionEvent);
      MathUtils.a(paramMotionEvent, this.jdField_d_of_type_AndroidGraphicsPointF);
      this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.a(this.jdField_d_of_type_AndroidGraphicsPointF);
      this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.b(this.jdField_c_of_type_AndroidGraphicsPointF);
      this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.a();
      this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF.b();
      paramView = this.jdField_a_of_type_ComTencentAvOpenglGestureVectorF;
      paramView.jdField_b_of_type_Float /= this.jdField_b_of_type_Float;
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX();
        this.jdField_b_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY();
        this.jdField_c_of_type_AndroidGraphicsPointF.x = this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a();
        this.jdField_c_of_type_AndroidGraphicsPointF.y = this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
        return true;
      }
    } while ((this.jdField_e_of_type_Boolean) || (!a(paramMotionEvent.getX(), paramMotionEvent.getY())));
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
    return true;
  }
  
  public float b()
  {
    return this.i;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a();
  }
  
  public void b(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void c()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidGraphicsPointF.x = this.l;
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidGraphicsPointF.y = this.m;
    }
    e();
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.a()) {
        break label138;
      }
      this.jdField_c_of_type_Float = this.j;
    }
    for (this.jdField_b_of_type_Float = this.j;; this.jdField_b_of_type_Float = this.k)
    {
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setScale(this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setPosition(this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_c_of_type_AndroidGraphicsPointF.y);
      this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
      return;
      label138:
      this.jdField_c_of_type_Float = this.k;
    }
  }
  
  public void c(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Float = this.n;
    this.jdField_c_of_type_AndroidGraphicsPointF.x = this.l;
    this.jdField_c_of_type_AndroidGraphicsPointF.y = this.m;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    f();
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setScale(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setPosition(this.jdField_c_of_type_AndroidGraphicsPointF.x, this.jdField_c_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
  }
  
  public void d(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_AndroidGraphicsPointF.x < this.jdField_d_of_type_Float) {
      this.jdField_c_of_type_AndroidGraphicsPointF.x = this.jdField_d_of_type_Float;
    }
    do
    {
      while (this.jdField_c_of_type_AndroidGraphicsPointF.y < this.jdField_e_of_type_Float)
      {
        this.jdField_c_of_type_AndroidGraphicsPointF.y = this.jdField_e_of_type_Float;
        return;
        if (this.jdField_c_of_type_AndroidGraphicsPointF.x > this.jdField_f_of_type_Float) {
          this.jdField_c_of_type_AndroidGraphicsPointF.x = this.jdField_f_of_type_Float;
        }
      }
    } while (this.jdField_c_of_type_AndroidGraphicsPointF.y <= this.g);
    this.jdField_c_of_type_AndroidGraphicsPointF.y = this.g;
  }
  
  public void f()
  {
    boolean bool2 = true;
    int i1 = Math.round(this.jdField_e_of_type_Int * this.jdField_c_of_type_Float);
    int i2 = Math.round(this.jdField_f_of_type_Int * this.jdField_c_of_type_Float);
    if (i1 > this.jdField_c_of_type_Int)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (i2 <= this.jdField_d_of_type_Int) {
        break label147;
      }
    }
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_d_of_type_Boolean = bool1;
      float f1;
      if (this.jdField_c_of_type_Boolean)
      {
        f1 = (i1 - this.jdField_c_of_type_Int) / 2.0F;
        this.jdField_d_of_type_Float = (this.l - f1);
        this.jdField_f_of_type_Float = (f1 + this.l);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        f1 = (i2 - this.jdField_d_of_type_Int) / 2.0F;
        this.jdField_e_of_type_Float = (this.m - f1);
        this.g = (f1 + this.m);
      }
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.GlViewTouchListener
 * JD-Core Version:    0.7.0.1
 */