package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.util.ViscousFluidInterpolator;

public class AnimationView
  extends View
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int jdField_d_of_type_Int = 1;
  private static final int jdField_e_of_type_Int = 2;
  private static final int jdField_f_of_type_Int = 3;
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long = 0L;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  private AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister;
  ViscousFluidInterpolator jdField_a_of_type_ComTencentUtilViscousFluidInterpolator = new ViscousFluidInterpolator();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long = 350L;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  boolean jdField_c_of_type_Boolean = true;
  float jdField_d_of_type_Float;
  private Rect jdField_d_of_type_AndroidGraphicsRect;
  private boolean jdField_d_of_type_Boolean;
  float jdField_e_of_type_Float;
  private Rect jdField_e_of_type_AndroidGraphicsRect;
  private boolean jdField_e_of_type_Boolean;
  private Rect jdField_f_of_type_AndroidGraphicsRect;
  private int jdField_g_of_type_Int = 3;
  private Rect jdField_g_of_type_AndroidGraphicsRect = new Rect();
  private int h = 3;
  private int i;
  private int j;
  private int k;
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = new Rect();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidGraphicsRect = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.copyBounds();
    this.jdField_g_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_g_of_type_AndroidGraphicsRect);
  }
  
  private void a(Canvas paramCanvas)
  {
    switch (this.jdField_g_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_g_of_type_Int = 3;
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
          this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.b();
        }
        super.onDraw(paramCanvas);
        return;
      }
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_g_of_type_Int = 2;
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / (float)this.jdField_c_of_type_Long;
      if (f1 >= 1.0F) {
        this.jdField_g_of_type_Int = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = 1.0F - this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation(f1);
      Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
      Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int m = localRect2.width();
      int n = localRect2.height();
      float f2 = localRect1.width();
      float f3 = localRect1.height();
      float f4 = f2 / m;
      float f5 = f3 / n;
      paramCanvas.save();
      if (this.i == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * (m - f2 / f5), localRect2.bottom - arrayOfInt[1]);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        if (this.i == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (n - f3 / f4));
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.b();
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_c_of_type_AndroidGraphicsRect);
  }
  
  private void b(Canvas paramCanvas)
  {
    switch (this.h)
    {
    default: 
    case 1: 
      do
      {
        return;
        if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_b_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
          break;
        }
        this.h = 3;
        this.jdField_e_of_type_Boolean = false;
        super.onDraw(paramCanvas);
      } while (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister == null);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.e();
      return;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.h = 2;
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / (float)this.jdField_c_of_type_Long;
      if (f1 >= 1.0F) {
        this.h = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = this.jdField_a_of_type_ComTencentUtilViscousFluidInterpolator.getInterpolation(f1);
      Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
      Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int m = localRect2.right - localRect2.left;
      int n = localRect2.bottom - localRect2.top;
      float f2 = localRect1.right - localRect1.left + this.j;
      float f3 = localRect1.bottom - localRect1.top + this.k;
      float f4 = f2 / m;
      float f5 = f3 / n;
      paramCanvas.save();
      if (this.i == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.j - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - this.k - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.j / (1.0F - (1.0F - f5) * f1) * f1, localRect2.top - arrayOfInt[1] + this.k / (1.0F - (1.0F - f5) * f1) * f1, localRect2.right - arrayOfInt[0] - f1 * (m - f2 / f5), localRect2.bottom - arrayOfInt[1]);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        if (this.i == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.j - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - this.k - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.j / (1.0F - (1.0F - f4) * f1) * f1, localRect2.top - arrayOfInt[1] + this.k / (1.0F - (1.0F - f4) * f1) * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (n - f3 / f4));
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.e();
    }
    this.jdField_e_of_type_Boolean = false;
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_c_of_type_AndroidGraphicsRect);
  }
  
  private void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f1;
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_e_of_type_Float = ((float)l / (float)this.jdField_c_of_type_Long);
      if (!this.jdField_c_of_type_Boolean) {
        break label468;
      }
      this.jdField_e_of_type_Float = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation(this.jdField_e_of_type_Float);
      f1 = 1.0F - this.jdField_e_of_type_Float;
      if (this.jdField_a_of_type_Boolean)
      {
        if (l > this.jdField_c_of_type_Long) {
          break label486;
        }
        this.jdField_a_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.top * f1 + this.jdField_e_of_type_AndroidGraphicsRect.top * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.bottom * f1 + this.jdField_e_of_type_AndroidGraphicsRect.bottom * this.jdField_e_of_type_Float);
        this.jdField_c_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.left * f1 + this.jdField_e_of_type_AndroidGraphicsRect.left * this.jdField_e_of_type_Float);
        this.jdField_d_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.right * f1 + this.jdField_e_of_type_AndroidGraphicsRect.right * this.jdField_e_of_type_Float);
        this.f.set((int)this.jdField_c_of_type_Float, (int)this.jdField_a_of_type_Float, (int)this.jdField_d_of_type_Float, (int)this.jdField_b_of_type_Float);
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.top * f1 + this.jdField_b_of_type_AndroidGraphicsRect.top * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.bottom * f1 + this.jdField_b_of_type_AndroidGraphicsRect.bottom * this.jdField_e_of_type_Float);
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.left * f1 + this.jdField_b_of_type_AndroidGraphicsRect.left * this.jdField_e_of_type_Float);
        this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.right * f1 + this.jdField_b_of_type_AndroidGraphicsRect.right * this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, this.jdField_d_of_type_Float, this.jdField_b_of_type_Float);
      }
    }
    for (;;)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.f.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.f.height();
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left - this.f.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top - this.f.top * f2);
      paramCanvas.scale(f1, f2);
      paramCanvas.clipRect(this.f);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      invalidate();
      paramCanvas.restore();
      return;
      label468:
      this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentUtilViscousFluidInterpolator.getInterpolation(this.jdField_e_of_type_Float);
      break;
      label486:
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.b();
        } else {
          this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.e();
        }
      }
    }
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.h = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_AndroidGraphicsRect = paramDrawable.copyBounds();
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect2;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.jdField_c_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.d();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt, long paramLong)
  {
    this.jdField_g_of_type_Int = 1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_AndroidGraphicsRect = paramDrawable.copyBounds();
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect2;
    this.i = paramInt;
    this.jdField_c_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.c();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_e_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect3;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect4;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Long = paramLong;
    a();
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.c();
    }
  }
  
  public void b(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_e_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect4;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect3;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Long = paramLong;
    a();
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.d();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      c(paramCanvas);
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      a(paramCanvas);
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAnimationListener(AnimationLister paramAnimationLister)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = paramAnimationLister;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationView
 * JD-Core Version:    0.7.0.1
 */