package com.tencent.widget;

import android.content.Context;
import android.util.FloatMath;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;
import fky;

public class OverScroller
{
  private static final int jdField_b_of_type_Int = 250;
  private static final int c = 0;
  private static final int d = 1;
  private int jdField_a_of_type_Int;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final fky jdField_a_of_type_Fky;
  private final boolean jdField_a_of_type_Boolean;
  private final fky jdField_b_of_type_Fky;
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this(paramContext, paramInterpolator, paramBoolean);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Fky = new fky();
    this.b = new fky();
    fky.a(paramContext);
  }
  
  public float a()
  {
    return FloatMath.sqrt(fky.a(this.jdField_a_of_type_Fky) * fky.a(this.jdField_a_of_type_Fky) + fky.a(this.b) * fky.a(this.b));
  }
  
  public final int a()
  {
    return fky.a(this.jdField_a_of_type_Fky);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Fky.a();
    this.b.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Fky.a(paramFloat);
    this.b.a(paramFloat);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Fky.b(paramInt);
    this.b.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Fky.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Fky.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = fky.a(this.jdField_a_of_type_Fky);
      float f2 = fky.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Fky.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    fky.a(this.jdField_a_of_type_Fky, paramLong);
    fky.a(this.b, paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    fky.a(this.jdField_a_of_type_Fky, fky.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (fky.a(this.jdField_a_of_type_Fky)) && (fky.a(this.b));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = fky.c(this.jdField_a_of_type_Fky);
    int j = fky.b(this.jdField_a_of_type_Fky);
    int k = fky.c(this.b);
    int m = fky.b(this.b);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Fky.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.b.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public final int b()
  {
    return fky.a(this.b);
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Fky.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.b(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - fky.a(this.jdField_a_of_type_Fky);
      int i = fky.d(this.jdField_a_of_type_Fky);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = AnimateUtils.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!fky.a(this.jdField_a_of_type_Fky)) {
            this.jdField_a_of_type_Fky.b(f);
          }
          if (fky.a(this.b)) {
            break;
          }
          this.b.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!fky.a(this.jdField_a_of_type_Fky)) && (!this.jdField_a_of_type_Fky.b()) && (!this.jdField_a_of_type_Fky.a())) {
        this.jdField_a_of_type_Fky.a();
      }
      if ((!fky.a(this.b)) && (!this.b.b()) && (!this.b.a())) {
        this.b.a();
      }
    }
  }
  
  public final int c()
  {
    return fky.b(this.jdField_a_of_type_Fky);
  }
  
  @Deprecated
  public void c(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public boolean c()
  {
    return ((!fky.a(this.jdField_a_of_type_Fky)) && (fky.e(this.jdField_a_of_type_Fky) != 0)) || ((!fky.a(this.b)) && (fky.e(this.b) != 0));
  }
  
  public final int d()
  {
    return fky.b(this.b);
  }
  
  public final int e()
  {
    return fky.c(this.jdField_a_of_type_Fky);
  }
  
  public final int f()
  {
    return fky.c(this.b);
  }
  
  @Deprecated
  public final int g()
  {
    return Math.max(fky.d(this.jdField_a_of_type_Fky), fky.d(this.b));
  }
  
  public int h()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(fky.a(this.jdField_a_of_type_Fky), fky.a(this.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.OverScroller
 * JD-Core Version:    0.7.0.1
 */