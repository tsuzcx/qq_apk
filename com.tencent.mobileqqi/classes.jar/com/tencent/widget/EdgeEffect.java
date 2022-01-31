package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class EdgeEffect
{
  private static final float jdField_a_of_type_Float = 0.8F;
  private static final int jdField_a_of_type_Int = 1000;
  private static final String jdField_a_of_type_JavaLangString = "EdgeEffect";
  private static final float jdField_b_of_type_Float = 0.7F;
  private static final int jdField_b_of_type_Int = 167;
  private static final float jdField_c_of_type_Float = 0.5F;
  private static final int jdField_c_of_type_Int = 1000;
  private static final float jdField_d_of_type_Float = 0.5F;
  private static final int jdField_d_of_type_Int = 100;
  private static final float jdField_e_of_type_Float = 0.5F;
  private static final float jdField_f_of_type_Float = 4.0F;
  private static final float jdField_g_of_type_Float = 1.0F;
  private static final float jdField_h_of_type_Float = 0.6F;
  private static final float jdField_i_of_type_Float = 0.001F;
  private static final int jdField_i_of_type_Int = 0;
  private static final int jdField_j_of_type_Int = 1;
  private static final int jdField_k_of_type_Int = 2;
  private static final int jdField_l_of_type_Int = 3;
  private static final int jdField_m_of_type_Int = 4;
  private static final int jdField_n_of_type_Int = 7;
  private static final int jdField_o_of_type_Int = 7;
  private static final int jdField_p_of_type_Int = 8;
  private static final int jdField_q_of_type_Int = 16;
  private static final float w = 1.1F;
  private long jdField_a_of_type_Long;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_e_of_type_Int;
  private int jdField_f_of_type_Int;
  private final int jdField_g_of_type_Int;
  private final int jdField_h_of_type_Int;
  private float jdField_j_of_type_Float;
  private float jdField_k_of_type_Float;
  private float jdField_l_of_type_Float;
  private float jdField_m_of_type_Float;
  private float jdField_n_of_type_Float;
  private float jdField_o_of_type_Float;
  private float jdField_p_of_type_Float;
  private float jdField_q_of_type_Float;
  private float jdField_r_of_type_Float;
  private int jdField_r_of_type_Int = 0;
  private float s;
  private float t;
  private float u;
  private float v;
  private float x;
  
  public EdgeEffect(Context paramContext)
  {
    this.g = 300;
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130838151);
    this.b = paramContext.getDrawable(2130838152);
    this.h = ((int)(paramContext.getDisplayMetrics().density * 300.0F + 0.5F));
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
  }
  
  private void c()
  {
    float f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) / this.v, 1.0F);
    float f2 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1);
    this.j = (this.n + (this.o - this.n) * f2);
    this.k = (this.p + (this.q - this.p) * f2);
    this.l = (this.jdField_r_of_type_Float + (this.s - this.jdField_r_of_type_Float) * f2);
    this.m = (this.t + (this.u - this.t) * f2);
    if (f1 >= 0.999F) {}
    switch (this.jdField_r_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_r_of_type_Int = 3;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.v = 1000.0F;
      this.n = this.j;
      this.p = this.k;
      this.jdField_r_of_type_Float = this.l;
      this.t = this.m;
      this.o = 0.0F;
      this.q = 0.0F;
      this.s = 0.0F;
      this.u = 0.0F;
      return;
    case 1: 
      this.jdField_r_of_type_Int = 4;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.v = 1000.0F;
      this.n = this.j;
      this.p = this.k;
      this.jdField_r_of_type_Float = this.l;
      this.t = this.m;
      this.o = 0.0F;
      this.q = 0.0F;
      this.s = 0.0F;
      this.u = 0.0F;
      return;
    case 4: 
      if (this.u != 0.0F) {}
      for (f1 = 1.0F / (this.u * this.u);; f1 = 3.4028235E+38F)
      {
        float f3 = this.p;
        this.k = (f1 * (f2 * (this.q - this.p)) + f3);
        this.jdField_r_of_type_Int = 3;
        return;
      }
    }
    this.jdField_r_of_type_Int = 0;
  }
  
  public void a()
  {
    this.jdField_r_of_type_Int = 0;
  }
  
  public void a(float paramFloat)
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if ((this.jdField_r_of_type_Int == 4) && ((float)(l1 - this.jdField_a_of_type_Long) < this.v)) {
      return;
    }
    if (this.jdField_r_of_type_Int != 1) {
      this.m = 1.0F;
    }
    this.jdField_r_of_type_Int = 1;
    this.jdField_a_of_type_Long = l1;
    this.v = 167.0F;
    this.x += paramFloat;
    float f1 = Math.abs(this.x);
    float f2 = Math.max(0.6F, Math.min(f1, 0.8F));
    this.n = f2;
    this.j = f2;
    f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
    this.p = f1;
    this.k = f1;
    f1 = Math.min(0.8F, this.l + Math.abs(paramFloat) * 1.1F);
    this.jdField_r_of_type_Float = f1;
    this.l = f1;
    f2 = Math.abs(paramFloat);
    f1 = f2;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      if (this.x < 0.0F) {
        f1 = -f2;
      }
    }
    if (this.x == 0.0F) {
      this.m = 0.0F;
    }
    paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.m));
    this.t = paramFloat;
    this.m = paramFloat;
    this.o = this.j;
    this.q = this.k;
    this.s = this.l;
    this.u = this.m;
  }
  
  public void a(int paramInt)
  {
    this.jdField_r_of_type_Int = 2;
    paramInt = Math.max(100, Math.abs(paramInt));
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.v = (0.1F + paramInt * 0.03F);
    this.n = 0.0F;
    this.p = 0.0F;
    this.k = 0.0F;
    this.jdField_r_of_type_Float = 0.5F;
    this.t = 0.0F;
    this.o = Math.max(0, Math.min(paramInt * 8, 1));
    this.q = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
    this.u = Math.min(0.025F + paramInt / 100 * paramInt * 0.00015F, 1.75F);
    this.s = Math.max(this.jdField_r_of_type_Float, Math.min(paramInt * 16 * 1.0E-005F, 0.8F));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public boolean a()
  {
    return this.jdField_r_of_type_Int == 0;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool = false;
    c();
    int i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i2 = this.b.getIntrinsicHeight();
    int i3 = this.b.getIntrinsicWidth();
    this.b.setAlpha((int)(Math.max(0.0F, Math.min(this.l, 1.0F)) * 255.0F));
    i2 = (int)Math.min(i2 * this.m * i2 / i3 * 0.6F, i2 * 4.0F);
    if (this.e < this.h)
    {
      i3 = (this.e - this.h) / 2;
      this.b.setBounds(i3, 0, this.e - i3, i2);
      this.b.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha((int)(Math.max(0.0F, Math.min(this.j, 1.0F)) * 255.0F));
      i1 = (int)(i1 * this.k);
      if (this.e >= this.h) {
        break label249;
      }
      i2 = (this.e - this.h) / 2;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i2, 0, this.e - i2, i1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      if (this.jdField_r_of_type_Int != 0) {
        bool = true;
      }
      return bool;
      this.b.setBounds(0, 0, this.e, i2);
      break;
      label249:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, i1);
    }
  }
  
  public void b()
  {
    this.x = 0.0F;
    if ((this.jdField_r_of_type_Int != 1) && (this.jdField_r_of_type_Int != 4)) {
      return;
    }
    this.jdField_r_of_type_Int = 3;
    this.n = this.j;
    this.p = this.k;
    this.jdField_r_of_type_Float = this.l;
    this.t = this.m;
    this.o = 0.0F;
    this.q = 0.0F;
    this.s = 0.0F;
    this.u = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.v = 1000.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.EdgeEffect
 * JD-Core Version:    0.7.0.1
 */