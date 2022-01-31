package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Transformation;
import com.tencent.widget.VerticalGallery;

public class WheelView
  extends VerticalGallery
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { -15658735, 11184810, 11184810 };
  private float jdField_a_of_type_Float = -0.1F;
  private Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
  private float jdField_b_of_type_Float = 0.8F;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private GradientDrawable jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = null;
  private boolean jdField_b_of_type_Boolean = false;
  private float c = -25.0F;
  private int i = 0;
  private int j = 80;
  private int k = -80;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(View paramView)
  {
    int m = d(paramView);
    float f2 = (this.i - m) / this.i * this.j;
    float f1;
    if (f2 > this.j) {
      f1 = this.j;
    }
    do
    {
      return f1;
      f1 = f2;
    } while (f2 >= -this.j);
    return -this.j;
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, jdField_a_of_type_ArrayOfInt);
    this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, jdField_a_of_type_ArrayOfInt);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.k = -40;
    }
  }
  
  private void a(View paramView, Transformation paramTransformation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramTransformation.clear();
    paramTransformation.setTransformationType(3);
    Matrix localMatrix = paramTransformation.getMatrix();
    int m = paramView.getWidth();
    int n = paramView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsCamera.save();
    this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    this.jdField_a_of_type_AndroidGraphicsCamera.rotateX(paramFloat1);
    this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(localMatrix);
    localMatrix.preSkew(paramFloat3, 0.0F);
    localMatrix.preTranslate(paramFloat5, 0.0F);
    localMatrix.preTranslate(-m / 2, -n / 2);
    localMatrix.postTranslate(m / 2, n / 2);
    this.jdField_a_of_type_AndroidGraphicsCamera.restore();
  }
  
  private float b(View paramView)
  {
    int m = d(paramView);
    if (m < this.i) {
      return m / this.i * this.k;
    }
    if (m > this.i) {
      return (this.i * 2 - m) / this.i * this.k;
    }
    return this.k;
  }
  
  private float c(View paramView)
  {
    float f = this.jdField_b_of_type_Float;
    return (1.0F - Math.abs(d(paramView) - this.i) / this.i) * this.jdField_b_of_type_Float;
  }
  
  private float d(View paramView)
  {
    int m = d(paramView);
    if (this.jdField_a_of_type_Float == -0.1F) {
      return (this.i - m) / this.i * this.jdField_a_of_type_Float;
    }
    return (this.i - m) / this.i * this.jdField_a_of_type_Float;
  }
  
  private int d(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private float e(View paramView)
  {
    float f = 0.0F;
    int m = d(paramView);
    if (this.jdField_b_of_type_Boolean) {
      f = Math.abs(this.i - m) / this.i * this.c;
    }
    return f;
  }
  
  private int f()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  protected void B_()
  {
    super.B_();
    playSoundEffect(0);
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = a(paramView);
    float f2 = b(paramView);
    float f3 = d(paramView);
    float f4 = e(paramView);
    a(paramView, paramTransformation, f1, f2, f3, c(paramView), f4);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = f();
    paramInt2 = b();
    View localView = getChildAt(0);
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 50)
    {
      paramInt2 -= paramInt1 / 2;
      this.jdField_b_of_type_AndroidGraphicsRect.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.i = f();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = f();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */