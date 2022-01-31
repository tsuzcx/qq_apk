package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.R.styleable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockPatternView
  extends View
{
  static final int jdField_a_of_type_Int = 25;
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int jdField_e_of_type_Int = 700;
  private float jdField_a_of_type_Float = -1.0F;
  private long jdField_a_of_type_Long;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private LockPatternView.DisplayMode jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode = LockPatternView.DisplayMode.Correct;
  private LockPatternView.OnPatternListener jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(9);
  private boolean[][] jdField_a_of_type_Array2dOfBoolean = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private float jdField_b_of_type_Float = -1.0F;
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.3F;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.6F;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private final int jdField_f_of_type_Int = 128;
  private boolean jdField_f_of_type_Boolean = false;
  private float jdField_g_of_type_Float = 3.0F;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  
  public LockPatternView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.j).getString(0);
    if ("square".equals(paramContext)) {
      this.r = 0;
    }
    for (;;)
    {
      setClickable(true);
      this.s = getResources().getColor(2131427374);
      this.t = getResources().getColor(2131427375);
      this.u = getResources().getDimensionPixelSize(2131492988);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.s);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.u);
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_g_of_type_Int);
      this.jdField_g_of_type_Int = getResources().getColor(2131427378);
      this.jdField_h_of_type_Int = getResources().getColor(2131427379);
      this.i = getResources().getColor(2131427380);
      this.j = getResources().getColor(2131427381);
      this.k = getResources().getColor(2131427382);
      this.l = getResources().getColor(2131427383);
      this.m = getResources().getColor(2131427384);
      this.n = getResources().getColor(2131427385);
      this.o = getResources().getColor(2131427386);
      this.jdField_g_of_type_Float = getResources().getDimensionPixelSize(2131492989);
      this.p = (getWidth() / 4);
      this.q = (getHeight() / 4);
      return;
      if ("lock_width".equals(paramContext)) {
        this.r = 1;
      } else if ("lock_height".equals(paramContext)) {
        this.r = 2;
      } else {
        this.r = 0;
      }
    }
  }
  
  private float a(int paramInt)
  {
    return getPaddingLeft() + paramInt * this.jdField_e_of_type_Float + this.jdField_e_of_type_Float / 2.0F;
  }
  
  private int a(float paramFloat)
  {
    float f1 = this.jdField_f_of_type_Float;
    float f2 = f1 * this.jdField_d_of_type_Float;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i1 = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i1 = i2;
    case 0: 
      return i1;
    }
    return Math.min(i2, paramInt2);
  }
  
  private LockPatternView.Cell a(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i2 = -1;
    LockPatternView.Cell localCell = b(paramFloat1, paramFloat2);
    int i3;
    int i1;
    if (localCell != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localObject1 = localObject2;
      if (!localArrayList.isEmpty())
      {
        localObject1 = (LockPatternView.Cell)localArrayList.get(localArrayList.size() - 1);
        int i6 = localCell.a - ((LockPatternView.Cell)localObject1).a;
        int i5 = localCell.b - ((LockPatternView.Cell)localObject1).b;
        int i4 = ((LockPatternView.Cell)localObject1).a;
        i3 = ((LockPatternView.Cell)localObject1).b;
        i1 = i4;
        if (Math.abs(i6) == 2)
        {
          i1 = i4;
          if (Math.abs(i5) != 1)
          {
            i4 = ((LockPatternView.Cell)localObject1).a;
            if (i6 <= 0) {
              break label252;
            }
            i1 = 1;
            i1 += i4;
          }
        }
        if ((Math.abs(i5) != 2) || (Math.abs(i6) == 1)) {
          break label257;
        }
        i3 = ((LockPatternView.Cell)localObject1).b;
        if (i5 > 0) {
          i2 = 1;
        }
      }
    }
    label257:
    for (i2 = i3 + i2;; i2 = i3)
    {
      localObject1 = LockPatternView.Cell.a(i1, i2);
      if ((this.jdField_g_of_type_Boolean) && (localObject1 != null) && (this.jdField_a_of_type_Array2dOfBoolean[localObject1.a][localObject1.b] == 0)) {
        a((LockPatternView.Cell)localObject1);
      }
      a(localCell);
      if (this.jdField_e_of_type_Boolean) {
        performHapticFeedback(1, 3);
      }
      localObject1 = localCell;
      return localObject1;
      label252:
      i1 = -1;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    setContentDescription(getContext().getString(paramInt));
    sendAccessibilityEvent(4);
    setContentDescription(null);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, LockPatternView.Cell paramCell1, LockPatternView.Cell paramCell2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode != LockPatternView.DisplayMode.Wrong) {}
    int i1 = paramCell2.a;
    int i2 = paramCell1.a;
    int i3 = paramCell2.b;
    int i4 = paramCell1.b;
    int i5 = ((int)this.jdField_e_of_type_Float - this.p) / 2;
    int i6 = ((int)this.jdField_f_of_type_Float - this.q) / 2;
    Log.v("--->>", i5 + " " + i6 + " offset");
    int i7 = this.p;
    int i8 = this.q;
    float f1 = (float)Math.toDegrees((float)Math.atan2(i1 - i2, i3 - i4));
    float f2 = Math.min(this.jdField_e_of_type_Float / this.p, 1.0F);
    float f3 = Math.min(this.jdField_f_of_type_Float / this.q, 1.0F);
    this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(i5 + paramFloat1, i6 + paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.preTranslate(this.p / 2, this.q / 2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(f2, f3);
    this.jdField_a_of_type_AndroidGraphicsMatrix.preTranslate(-this.p / 2, -this.q / 2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.preRotate(f1 + 90.0F, i7 / 2.0F, i8 / 2.0F);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getHistorySize();
    int i1 = 0;
    if (i1 < i2 + 1)
    {
      float f4;
      label33:
      float f3;
      label48:
      float f6;
      float f5;
      float f2;
      float f1;
      float f7;
      label229:
      float f8;
      if (i1 < i2)
      {
        f4 = paramMotionEvent.getHistoricalX(i1);
        if (i1 >= i2) {
          break label541;
        }
        f3 = paramMotionEvent.getHistoricalY(i1);
        int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        LockPatternView.Cell localCell = a(f4, f3);
        int i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if ((localCell != null) && (i4 == 1))
        {
          this.jdField_f_of_type_Boolean = true;
          e();
        }
        if (Math.abs(f4 - this.jdField_a_of_type_Float) + Math.abs(f3 - this.jdField_b_of_type_Float) > 0.0F)
        {
          f6 = this.jdField_a_of_type_Float;
          f5 = this.jdField_b_of_type_Float;
          this.jdField_a_of_type_Float = f4;
          this.jdField_b_of_type_Float = f3;
          if ((!this.jdField_f_of_type_Boolean) || (i4 <= 0)) {
            break label614;
          }
          ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          float f9 = this.jdField_e_of_type_Float * this.jdField_c_of_type_Float * 0.5F;
          Object localObject = (LockPatternView.Cell)localArrayList.get(i4 - 1);
          f2 = a(((LockPatternView.Cell)localObject).b);
          f1 = b(((LockPatternView.Cell)localObject).a);
          localObject = this.jdField_a_of_type_AndroidGraphicsRect;
          if (f2 >= f4) {
            break label550;
          }
          f7 = f2;
          if (f1 >= f3) {
            break label568;
          }
          f8 = f1;
          label239:
          ((Rect)localObject).set((int)(f7 - f9), (int)(f8 - f9), (int)(f4 + f9), (int)(f3 + f9));
          if (f2 >= f6) {
            break label578;
          }
          f3 = f2;
          f2 = f6;
          label281:
          f6 = f1;
          f4 = f5;
          if (f1 < f5)
          {
            f4 = f1;
            f6 = f5;
          }
          ((Rect)localObject).union((int)(f3 - f9), (int)(f4 - f9), (int)(f2 + f9), (int)(f6 + f9));
          if (localCell != null)
          {
            f2 = a(localCell.b);
            f1 = b(localCell.a);
            if (i4 < 2) {
              break label595;
            }
            localCell = (LockPatternView.Cell)localArrayList.get(i4 - 1 - (i4 - i3));
            f6 = a(localCell.b);
            f5 = b(localCell.a);
            f3 = f2;
            f4 = f6;
            if (f2 < f6)
            {
              f3 = f6;
              f4 = f2;
            }
            if (f1 >= f5) {
              break label585;
            }
            f2 = f3;
            f3 = f1;
            f1 = f5;
            label440:
            f5 = this.jdField_e_of_type_Float / 1.0F;
            f6 = this.jdField_f_of_type_Float / 1.0F;
            ((Rect)localObject).set((int)(f4 - f5), (int)(f3 - f6), (int)(f2 + f5), (int)(f1 + f6));
          }
          if (QLog.isColorLevel()) {
            QLog.d("LockPatternView", 2, "move invalidate.rect=" + localObject);
          }
          invalidate((Rect)localObject);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        f4 = paramMotionEvent.getX();
        break label33;
        label541:
        f3 = paramMotionEvent.getY();
        break label48;
        label550:
        f7 = f2;
        f8 = f4;
        f4 = f7;
        f7 = f8;
        break label229;
        label568:
        f8 = f3;
        f3 = f1;
        break label239;
        label578:
        f3 = f6;
        break label281;
        label585:
        f2 = f3;
        f3 = f5;
        break label440;
        label595:
        f3 = f1;
        f4 = f2;
        f5 = f1;
        f1 = f3;
        f3 = f5;
        break label440;
        label614:
        if (QLog.isColorLevel()) {
          QLog.d("LockPatternView", 2, "move invalidate.all");
        }
        invalidate();
      }
    }
  }
  
  private void a(LockPatternView.Cell paramCell)
  {
    this.jdField_a_of_type_Array2dOfBoolean[paramCell.a()][paramCell.b()] = 1;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCell);
    d();
  }
  
  private float b(int paramInt)
  {
    return getPaddingTop() + paramInt * this.jdField_f_of_type_Float + this.jdField_f_of_type_Float / 2.0F;
  }
  
  private int b(float paramFloat)
  {
    float f1 = this.jdField_e_of_type_Float;
    float f2 = f1 * this.jdField_d_of_type_Float;
    float f3 = getPaddingLeft();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private LockPatternView.Cell b(float paramFloat1, float paramFloat2)
  {
    int i1 = a(paramFloat2);
    if (i1 < 0) {}
    int i2;
    do
    {
      return null;
      i2 = b(paramFloat1);
    } while ((i2 < 0) || (this.jdField_a_of_type_Array2dOfBoolean[i1][i2] != 0));
    return LockPatternView.Cell.a(i1, i2);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i3;
    int i2;
    int i1;
    if ((!paramBoolean) || ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode != LockPatternView.DisplayMode.Wrong)))
    {
      i3 = this.j;
      i2 = this.jdField_g_of_type_Int;
      i1 = this.m;
    }
    for (;;)
    {
      float f2 = this.jdField_e_of_type_Float;
      float f1 = this.jdField_f_of_type_Float;
      int i4 = (int)(3.0F * f2 / 4.0F);
      int i6 = (int)(3.0F * f1 / 4.0F);
      int i5 = (int)((f2 - i4) / 2.0F);
      i6 = (int)((f1 - i6) / 2.0F);
      float f3 = Math.min(this.jdField_e_of_type_Float / this.p, 1.0F);
      float f4 = Math.min(this.jdField_f_of_type_Float / this.q, 1.0F);
      this.jdField_b_of_type_AndroidGraphicsMatrix.setTranslate(i5 + paramInt1, i6 + paramInt2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(this.p / 2, this.q / 2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preScale(f3, f4);
      this.jdField_b_of_type_AndroidGraphicsMatrix.preTranslate(-this.p / 2, -this.q / 2);
      f3 = paramInt1;
      f2 = f2 / 2.0F + f3;
      f3 = paramInt2;
      f1 = f1 / 2.0F + f3;
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i1);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(f2, f1, i4 / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i2);
      paramCanvas.drawCircle(f2, f1, i4 * 18 / 100, this.jdField_c_of_type_AndroidGraphicsPaint);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_g_of_type_Float);
      paramCanvas.drawCircle(f2, f1, i4 / 2, this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
      if (this.jdField_f_of_type_Boolean)
      {
        i3 = this.k;
        i2 = this.jdField_h_of_type_Int;
        i1 = this.n;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode == LockPatternView.DisplayMode.Wrong)
      {
        i3 = this.l;
        i2 = this.i;
        i1 = this.o;
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode != LockPatternView.DisplayMode.Correct) && (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode != LockPatternView.DisplayMode.Animate)) {
          break;
        }
        i3 = this.j;
        i2 = this.jdField_h_of_type_Int;
        i1 = this.n;
      }
    }
    throw new IllegalStateException("unknown display mode " + this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_f_of_type_Boolean = false;
      f();
      invalidate();
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    h();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = a(f1, f2);
    if (paramMotionEvent != null)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode = LockPatternView.DisplayMode.Correct;
      e();
    }
    for (;;)
    {
      if (paramMotionEvent != null)
      {
        float f3 = a(paramMotionEvent.b);
        float f4 = b(paramMotionEvent.a);
        float f5 = this.jdField_e_of_type_Float / 2.0F;
        float f6 = this.jdField_f_of_type_Float / 2.0F;
        invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      return;
      this.jdField_f_of_type_Boolean = false;
      g();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener.b(this.jdField_a_of_type_JavaUtilArrayList);
    }
    a(2131364034);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener.a();
    }
    a(2131364032);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    a(2131364035);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener.b();
    }
    a(2131364033);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    i();
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode = LockPatternView.DisplayMode.Correct;
    invalidate();
  }
  
  private void i()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.jdField_a_of_type_Array2dOfBoolean[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a()
  {
    h();
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean c()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return this.q * 3;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return this.p * 3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LockPatternView", 2, "ondraw.");
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i4 = localArrayList.size();
    boolean[][] arrayOfBoolean = this.jdField_a_of_type_Array2dOfBoolean;
    int i3;
    int i1;
    Object localObject;
    float f3;
    float f4;
    int i5;
    int i6;
    label307:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode == LockPatternView.DisplayMode.Animate)
    {
      i2 = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) % ((i4 + 1) * 700);
      i3 = i2 / 700;
      i();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = (LockPatternView.Cell)localArrayList.get(i1);
        arrayOfBoolean[localObject.a()][localObject.b()] = 1;
        i1 += 1;
      }
      if ((i3 > 0) && (i3 < i4))
      {
        i1 = 1;
        if (i1 != 0)
        {
          f1 = i2 % 700 / 700.0F;
          localObject = (LockPatternView.Cell)localArrayList.get(i3 - 1);
          f2 = a(((LockPatternView.Cell)localObject).b);
          f3 = b(((LockPatternView.Cell)localObject).a);
          localObject = (LockPatternView.Cell)localArrayList.get(i3);
          f4 = a(((LockPatternView.Cell)localObject).b);
          float f5 = b(((LockPatternView.Cell)localObject).a);
          this.jdField_a_of_type_Float = (f2 + (f4 - f2) * f1);
          this.jdField_b_of_type_Float = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      f1 = this.jdField_e_of_type_Float;
      f2 = this.jdField_f_of_type_Float;
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      ((Path)localObject).rewind();
      i5 = getPaddingTop();
      i6 = getPaddingLeft();
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode != LockPatternView.DisplayMode.Wrong)) {
        break label404;
      }
      i1 = 1;
      if ((this.jdField_a_of_type_AndroidGraphicsPaint.getFlags() & 0x2) == 0) {
        break label410;
      }
      bool = true;
      label322:
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      i2 = 0;
    }
    for (;;)
    {
      if (i2 >= 3) {
        break label425;
      }
      f3 = i5;
      f4 = i2;
      i3 = 0;
      for (;;)
      {
        if (i3 < 3)
        {
          b(paramCanvas, (int)(i6 + i3 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[i2][i3]);
          i3 += 1;
          continue;
          i1 = 0;
          break;
          label404:
          i1 = 0;
          break label307;
          label410:
          bool = false;
          break label322;
        }
      }
      i2 += 1;
    }
    label425:
    if (i1 != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode == LockPatternView.DisplayMode.Wrong) {
        break label548;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.s);
    }
    LockPatternView.Cell localCell;
    for (;;)
    {
      i2 = 0;
      i1 = 0;
      if (i1 < i4)
      {
        localCell = (LockPatternView.Cell)localArrayList.get(i1);
        if (arrayOfBoolean[localCell.a][localCell.b] != 0) {
          break;
        }
      }
      if (((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode == LockPatternView.DisplayMode.Animate)) && (i2 != 0)) {
        ((Path)localObject).lineTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      paramCanvas.drawPath((Path)localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(bool);
      return;
      label548:
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.t);
    }
    int i2 = 1;
    float f1 = a(localCell.b);
    float f2 = b(localCell.a);
    if (i1 == 0) {
      ((Path)localObject).moveTo(f1, f2);
    }
    for (;;)
    {
      i1 += 1;
      break;
      ((Path)localObject).lineTo(f1, f2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getSuggestedMinimumWidth();
    int i2 = getSuggestedMinimumHeight();
    i1 = a(paramInt1, i1);
    paramInt1 = a(paramInt2, i2);
    switch (this.r)
    {
    default: 
      paramInt2 = i1;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = paramInt1;
      continue;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = i1;
      continue;
      paramInt2 = Math.min(i1, paramInt1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_e_of_type_Float = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.jdField_f_of_type_Float = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_c_of_type_Boolean) || (!isEnabled())) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      c(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    case 1: 
      b(paramMotionEvent);
      return true;
    case 2: 
      a(paramMotionEvent);
      return true;
    }
    h();
    this.jdField_f_of_type_Boolean = false;
    g();
    return true;
  }
  
  public void setDisplayMode(LockPatternView.DisplayMode paramDisplayMode)
  {
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$DisplayMode = paramDisplayMode;
    if (paramDisplayMode == LockPatternView.DisplayMode.Animate)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramDisplayMode = (LockPatternView.Cell)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      this.jdField_a_of_type_Float = a(paramDisplayMode.b());
      this.jdField_b_of_type_Float = b(paramDisplayMode.a());
      i();
    }
    invalidate();
  }
  
  public void setFillInGapCell(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setInStealthMode(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setOnPatternListener(LockPatternView.OnPatternListener paramOnPatternListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView$OnPatternListener = paramOnPatternListener;
  }
  
  public void setPattern(LockPatternView.DisplayMode paramDisplayMode, List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    i();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.next();
      this.jdField_a_of_type_Array2dOfBoolean[localCell.a()][localCell.b()] = 1;
    }
    setDisplayMode(paramDisplayMode);
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView
 * JD-Core Version:    0.7.0.1
 */