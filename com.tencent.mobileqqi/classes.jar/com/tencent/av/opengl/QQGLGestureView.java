package com.tencent.av.opengl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import bib;
import com.tencent.av.opengl.gesture.Animation;
import com.tencent.av.opengl.gesture.Animator;
import com.tencent.av.opengl.gesture.GlViewTouchListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class QQGLGestureView
  extends QQGlView
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View.OnTouchListener a;
  Animator jdField_a_of_type_ComTencentAvOpenglGestureAnimator;
  public GlViewTouchListener a;
  final Semaphore jdField_a_of_type_JavaUtilConcurrentSemaphore = new Semaphore(0);
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  float jdField_e_of_type_Float = 1.0F;
  int jdField_e_of_type_Int = 240;
  float jdField_f_of_type_Float = 4.0F;
  int jdField_f_of_type_Int = 320;
  float g = 0.75F;
  float h = 1.0F;
  float i = 1.0F;
  float j;
  float k;
  
  public QQGLGestureView(Context paramContext)
  {
    super(paramContext);
    this.c = 1.0F;
    this.d = -1.0F;
  }
  
  public QQGLGestureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = 1.0F;
    this.d = -1.0F;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator != null) {
      this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator.c();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float += paramFloat1;
    this.jdField_b_of_type_Float += paramFloat2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if ((paramInt3 == 0) || (paramInt3 == 2))
    {
      this.jdField_e_of_type_Int = super.getWidth();
      this.jdField_f_of_type_Int = (this.jdField_e_of_type_Int * paramInt2 / paramInt1);
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      ((QQGlRender)this.a.get()).setWaitViewResetGestureState(false);
      super.e();
      return;
      this.jdField_f_of_type_Int = super.getHeight();
      this.jdField_e_of_type_Int = (this.jdField_f_of_type_Int * paramInt2 / paramInt1);
    }
    super.setOnTouchListener(null);
    a();
    b(super.getWidth(), super.getHeight(), paramInt3);
    this.jdField_a_of_type_Float = this.j;
    this.jdField_b_of_type_Float = this.k;
    ((QQGlRender)this.a.get()).setWaitViewResetGestureState(false);
    super.e();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h = (paramInt3 / paramInt1);
    this.i = (paramInt4 / paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = 1.0F;
    float f1 = paramInt1 / paramInt3;
    if (paramInt2 / paramInt4 > 2.0F)
    {
      this.d = this.i;
      return;
    }
    if (f1 > 2.0F) {
      this.d = this.h;
    }
    Log.d("benjamin", "computeStartingScale,startingScale=" + this.d);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator != null) {
      this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator.a(paramAnimation);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = (super.getWidth() / 2.0F);
    this.k = (super.getHeight() / 2.0F);
    this.jdField_a_of_type_Float = this.j;
    this.jdField_b_of_type_Float = this.k;
    if (this.d > 0.0F) {}
    for (this.c = this.d;; this.c = 1.0F)
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener != null) {
        this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener = null;
      }
      if (paramBoolean) {
        b();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return a() >= b();
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentSemaphore.tryAcquire(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      d();
    }
    QQGlRender localQQGlRender = (QQGlRender)this.a.get();
    if (localQQGlRender != null) {
      localQQGlRender.notifyupdateui(1, 0);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public void b()
  {
    super.e();
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = a();
    int n = b();
    this.jdField_a_of_type_Int = Math.round(m / 2.0F);
    this.jdField_b_of_type_Int = Math.round(n / 2.0F);
    paramInt1 -= getPaddingLeft() + getPaddingRight();
    paramInt2 -= getPaddingTop() + getPaddingBottom();
    a(m, n, paramInt1, paramInt2);
    a(m, n, paramInt1, paramInt2, paramInt3);
    this.c = this.d;
    this.j = (paramInt1 / 2.0F);
    this.k = (paramInt2 / 2.0F);
    this.jdField_a_of_type_Float = this.j;
    this.jdField_b_of_type_Float = this.k;
    this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener = new GlViewTouchListener(this, paramInt1, paramInt2, this.c);
    if (a()) {
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.b(this.g * this.h);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a(this.jdField_f_of_type_Float * this.d);
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.c(this.h);
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.d(this.i);
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      super.setOnTouchListener(new bib(this));
      return;
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.b(this.g * this.i);
    }
  }
  
  public boolean b()
  {
    return a() <= b();
  }
  
  public float c()
  {
    return this.c;
  }
  
  public int c()
  {
    return Math.round(a() * c());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentSemaphore.availablePermits() <= 0) {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public float d()
  {
    return this.j;
  }
  
  public int d()
  {
    return Math.round(b() * c());
  }
  
  void d()
  {
    this.jdField_a_of_type_Boolean = false;
    a(true);
    super.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener != null) {
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener = null;
    }
  }
  
  public float e()
  {
    return this.k;
  }
  
  protected void onAttachedToWindow()
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator = new Animator(this, "GestureImageViewAnimator");
    this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator.start();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator != null) {
      this.jdField_a_of_type_ComTencentAvOpenglGestureAnimator.a();
    }
    super.onDetachedFromWindow();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      paramInt1 = super.getMeasuredWidth();
      paramInt2 = super.getMeasuredHeight();
    } while ((paramInt1 < 8) || (paramInt2 < 8));
    b(paramInt1, paramInt2, 0);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if (this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a(paramOnClickListener);
      return;
    }
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
    if (!this.jdField_a_of_type_Boolean) {
      super.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void setScale(float paramFloat)
  {
    Log.d("mlzhong", "setScale =" + paramFloat);
    this.c = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.QQGLGestureView
 * JD-Core Version:    0.7.0.1
 */