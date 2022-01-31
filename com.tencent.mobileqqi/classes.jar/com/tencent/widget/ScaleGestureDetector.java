package com.tencent.widget;

import android.content.Context;
import android.util.FloatMath;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class ScaleGestureDetector
{
  private static final float jdField_a_of_type_Float = 0.67F;
  private static final String jdField_a_of_type_JavaLangString = "ScaleGestureDetector";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Context jdField_a_of_type_AndroidContentContext;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private final ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  
  public ScaleGestureDetector(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener = paramOnScaleGestureListener;
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  private int a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    int m = paramMotionEvent.getPointerCount();
    int n = paramMotionEvent.findPointerIndex(paramInt1);
    paramInt1 = 0;
    while (paramInt1 < m)
    {
      if ((paramInt1 != paramInt2) && (paramInt1 != n)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_b_of_type_AndroidViewMotionEvent = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null) {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
    }
    this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.h = -1.0F;
    this.i = -1.0F;
    this.j = -1.0F;
    MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
    int m = localMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
    int n = localMotionEvent.findPointerIndex(this.jdField_b_of_type_Int);
    int i1 = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
    int i2 = paramMotionEvent.findPointerIndex(this.jdField_b_of_type_Int);
    if ((m < 0) || (n < 0) || (i1 < 0) || (i2 < 0))
    {
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e("ScaleGestureDetector", 2, "Invalid MotionEvent stream detected.", new Throwable());
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
      }
      return;
    }
    float f1 = localMotionEvent.getX(m);
    float f2 = localMotionEvent.getY(m);
    float f3 = localMotionEvent.getX(n);
    float f4 = localMotionEvent.getY(n);
    float f5 = paramMotionEvent.getX(i1);
    float f6 = paramMotionEvent.getY(i1);
    float f8 = paramMotionEvent.getX(i2);
    float f7 = paramMotionEvent.getY(i2);
    f8 -= f5;
    f7 -= f6;
    this.d = (f3 - f1);
    this.e = (f4 - f2);
    this.f = f8;
    this.g = f7;
    this.jdField_b_of_type_Float = (f8 * 0.5F + f5);
    this.jdField_c_of_type_Float = (f7 * 0.5F + f6);
    this.jdField_a_of_type_Long = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.k = (paramMotionEvent.getPressure(i1) + paramMotionEvent.getPressure(i2));
    f1 = localMotionEvent.getPressure(m);
    this.l = (localMotionEvent.getPressure(n) + f1);
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int n = 0;
    boolean bool2 = true;
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      a();
    }
    boolean bool1;
    if (this.jdField_b_of_type_Boolean) {
      bool1 = false;
    }
    label556:
    label633:
    label638:
    do
    {
      do
      {
        int i2;
        int i1;
        do
        {
          return bool1;
          if (!this.jdField_a_of_type_Boolean)
          {
            switch (m)
            {
            case 2: 
            case 3: 
            case 4: 
            default: 
              return true;
            case 0: 
              this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
              this.jdField_c_of_type_Boolean = true;
              return true;
            case 1: 
              a();
              return true;
            }
            if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
              this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
            }
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
            this.jdField_a_of_type_Long = 0L;
            m = a(paramMotionEvent);
            n = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
            this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(m);
            if ((n < 0) || (n == m)) {
              this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(a(paramMotionEvent, this.jdField_b_of_type_Int, -1));
            }
            this.jdField_c_of_type_Boolean = false;
            a(paramMotionEvent);
            this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            return true;
          }
          switch (m)
          {
          case 4: 
          default: 
            return true;
          case 1: 
            a();
            return true;
          case 5: 
            this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            m = this.jdField_a_of_type_Int;
            n = this.jdField_b_of_type_Int;
            a();
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
            if (this.jdField_c_of_type_Boolean) {}
            for (;;)
            {
              this.jdField_a_of_type_Int = m;
              this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(a(paramMotionEvent));
              this.jdField_c_of_type_Boolean = false;
              if ((paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int) < 0) || (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ScaleGestureDetector", 2, "Got " + paramMotionEvent.toString() + " with bad state while a gesture was in progress. " + "Did you forget to pass an event to " + "ScaleGestureDetector#onTouchEvent?");
                }
                this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(a(paramMotionEvent, this.jdField_b_of_type_Int, -1));
              }
              a(paramMotionEvent);
              this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
              return true;
              m = n;
            }
          case 6: 
            m = paramMotionEvent.getPointerCount();
            i2 = a(paramMotionEvent);
            i1 = paramMotionEvent.getPointerId(i2);
            if (m <= 2) {
              break label726;
            }
            if (i1 != this.jdField_a_of_type_Int) {
              break label638;
            }
            m = a(paramMotionEvent, this.jdField_b_of_type_Int, i2);
            if (m < 0) {
              break label633;
            }
            this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(m);
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
            a(paramMotionEvent);
            this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            m = 0;
            this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
            a(paramMotionEvent);
            bool1 = bool2;
          }
        } while (m == 0);
        a(paramMotionEvent);
        if (i1 == this.jdField_a_of_type_Int) {}
        for (m = this.jdField_b_of_type_Int;; m = this.jdField_a_of_type_Int)
        {
          n = paramMotionEvent.findPointerIndex(m);
          this.jdField_b_of_type_Float = paramMotionEvent.getX(n);
          this.jdField_c_of_type_Float = paramMotionEvent.getY(n);
          this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
          a();
          this.jdField_a_of_type_Int = m;
          this.jdField_c_of_type_Boolean = true;
          return true;
          m = 1;
          break;
          m = n;
          if (i1 != this.jdField_b_of_type_Int) {
            break;
          }
          m = a(paramMotionEvent, this.jdField_a_of_type_Int, i2);
          if (m >= 0)
          {
            this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(m);
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
            a(paramMotionEvent);
            this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
            m = n;
            break;
          }
          m = 1;
          break;
          m = 1;
          break label556;
        }
        this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.a(this);
        a();
        return true;
        a(paramMotionEvent);
        bool1 = bool2;
      } while (this.k / this.l <= 0.67F);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector$OnScaleGestureListener.b(this));
    label726:
    this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
    this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  public float b()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_AndroidViewMotionEvent.getEventTime();
  }
  
  public float c()
  {
    if (this.h == -1.0F)
    {
      float f1 = this.f;
      float f2 = this.g;
      this.h = FloatMath.sqrt(f1 * f1 + f2 * f2);
    }
    return this.h;
  }
  
  public float d()
  {
    return this.f;
  }
  
  public float e()
  {
    return this.g;
  }
  
  public float f()
  {
    if (this.i == -1.0F)
    {
      float f1 = this.d;
      float f2 = this.e;
      this.i = FloatMath.sqrt(f1 * f1 + f2 * f2);
    }
    return this.i;
  }
  
  public float g()
  {
    return this.d;
  }
  
  public float h()
  {
    return this.e;
  }
  
  public float i()
  {
    if (this.j == -1.0F) {
      this.j = (c() / f());
    }
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.ScaleGestureDetector
 * JD-Core Version:    0.7.0.1
 */