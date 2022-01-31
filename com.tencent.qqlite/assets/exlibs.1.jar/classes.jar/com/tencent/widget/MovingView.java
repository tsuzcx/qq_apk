package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import fim;
import java.util.Random;

public class MovingView
  extends View
{
  private static final float jdField_a_of_type_Float = 54.700001F;
  static final int jdField_a_of_type_Int = 40;
  public static final boolean a = true;
  static final int jdField_b_of_type_Int = 1000;
  static final int j = 1;
  static final int k = 2;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 0;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 3;
  private long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  public Handler a;
  public Scroller a;
  MovingView.MatrixParams jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams;
  Random jdField_a_of_type_JavaUtilRandom;
  private float jdField_b_of_type_Float;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  MovingView.MatrixParams jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams;
  public boolean b;
  private float c;
  public int c;
  public boolean c;
  public int d;
  private boolean d;
  public int e;
  public int f;
  int g;
  int h;
  int i;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w = 0;
  
  public MovingView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new fim(this, Looper.getMainLooper());
    f();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new fim(this, Looper.getMainLooper());
    f();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new fim(this, Looper.getMainLooper());
    f();
  }
  
  private Point a(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(3);
    switch (this.i)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsPoint;
      if (i1 == 0)
      {
        this.i = 2;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
      }
      else if (i1 == 1)
      {
        this.i = 3;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
      }
      else if (i1 == 2)
      {
        this.i = 1;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
        continue;
        if (i1 == 0)
        {
          this.i = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
          this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
        }
        else if (i1 == 1)
        {
          this.i = 2;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
          this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
        }
        else if (i1 == 2)
        {
          this.i = 3;
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (-paramInt1);
          this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
          continue;
          if (i1 == 0)
          {
            this.i = 3;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
          }
          else if (i1 == 1)
          {
            this.i = 1;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = (-paramInt2);
          }
          else if (i1 == 2)
          {
            this.i = 0;
            this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
            this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            continue;
            if (i1 == 0)
            {
              this.i = 1;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = 0;
            }
            else if (i1 == 1)
            {
              this.i = 0;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
            }
            else if (i1 == 2)
            {
              this.i = 2;
              this.jdField_a_of_type_AndroidGraphicsPoint.x = 0;
              this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
            }
          }
        }
      }
    }
  }
  
  private void a(Bitmap paramBitmap, MovingView.MatrixParams paramMatrixParams)
  {
    float f3 = paramBitmap.getWidth();
    float f4 = paramBitmap.getHeight();
    float f1 = this.jdField_b_of_type_Float / f3;
    float f2 = this.jdField_c_of_type_Float / f4;
    if (f1 > f2) {
      f2 = this.jdField_b_of_type_Float;
    }
    for (f1 *= f4;; f1 = this.jdField_c_of_type_Float)
    {
      paramMatrixParams.a = (f2 / f3);
      paramMatrixParams.jdField_b_of_type_Float = (f1 / f4);
      paramMatrixParams.jdField_c_of_type_Float = ((this.jdField_b_of_type_Float - f2) / 2.0F);
      paramMatrixParams.d = ((this.jdField_c_of_type_Float - f1) / 2.0F);
      return;
      f2 *= f3;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new LinearInterpolator());
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.i = 0;
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.s = 2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label26;
      }
      label8:
      if (paramInt1 <= paramInt2) {
        break label32;
      }
    }
    for (;;)
    {
      return (int)(paramInt1 * 54.700001F);
      paramInt1 = -paramInt1;
      break;
      label26:
      paramInt2 = -paramInt2;
      break label8;
      label32:
      paramInt1 = paramInt2;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate");
    }
    switch (this.i)
    {
    }
    for (;;)
    {
      Point localPoint = a(this.g, this.h);
      this.e = 0;
      this.f = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, localPoint.x, localPoint.y, a(localPoint.x, localPoint.y));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = (-this.h);
      continue;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      continue;
      this.jdField_c_of_type_Int = (-this.g);
      this.jdField_d_of_type_Int = (-this.h);
      continue;
      this.jdField_c_of_type_Int = (-this.g);
      this.jdField_d_of_type_Int = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_b_of_type_Float = (paramInt1 * paramFloat);
    this.jdField_c_of_type_Float = (paramInt2 * paramFloat);
    this.g = ((int)(paramInt1 * (paramFloat - 1.0F)));
    this.h = ((int)(paramInt2 * (paramFloat - 1.0F)));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == paramBitmap) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      for (;;)
      {
        this.v = 1000;
        this.t = 0;
        this.u = 255;
        this.w = 0;
        this.jdField_d_of_type_Boolean = true;
        this.s = 0;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_b_of_type_Boolean = false;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          }
        }
        invalidate();
        return;
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          if (this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams == null) {
            this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams = new MovingView.MatrixParams(this);
          }
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.a = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.a;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_c_of_type_Float = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_c_of_type_Float;
          this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.d = this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d;
        }
        if (this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams == null) {
          this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams = new MovingView.MatrixParams(this);
        }
        a(paramBitmap, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate, bitmap = null");
    }
    clearAnimation();
    postInvalidate();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap == null;
  }
  
  public float b()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "onPause");
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "onResume() mIsAnimStart " + this.jdField_b_of_type_Boolean + ", bitmap = " + this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    e();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "stopTranslate()");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = 1;
    int i1 = 1;
    super.onDraw(paramCanvas);
    if (getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, getVisibility() != View.VISIBLE");
      }
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      return;
    }
    switch (this.s)
    {
    }
    while (i1 != 0)
    {
      this.s = 2;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.a, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_c_of_type_Float + this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_d_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.s = 1;
        i1 = 0;
        continue;
        if (this.jdField_a_of_type_Long >= 0L)
        {
          float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.v;
          if (f1 >= 1.0D) {}
          for (i1 = i2;; i1 = 0)
          {
            this.w = ((int)(this.t + f1 * (this.u - this.t)));
            break;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "onDraw, bitmap = null 1");
        }
        paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
        return;
      }
    }
    i1 = this.w;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      boolean bool = this.jdField_d_of_type_Boolean;
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - i1);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.a, this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_c_of_type_Float + this.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_d_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (bool) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
      }
    }
    if (i1 > 0)
    {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label520;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i1);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.a, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.jdField_c_of_type_Float + this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentWidgetMovingView$MatrixParams.d + this.jdField_d_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    }
    for (;;)
    {
      invalidate();
      return;
      label520:
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, bitmap = null 2");
      }
      paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      e();
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (paramInt == 0) {
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          a(this.jdField_b_of_type_AndroidGraphicsBitmap);
        } else if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "setVisibility, bitmap = null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.MovingView
 * JD-Core Version:    0.7.0.1
 */