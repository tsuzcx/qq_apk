package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
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
  private static final int[] mP = { -15658735, 11184810, 11184810 };
  private int cFu = -80;
  private Rect cz = new Rect();
  private boolean czD;
  private int dtQ;
  private int dyg = 80;
  private GradientDrawable j;
  private GradientDrawable k;
  private Camera mCamera = new Camera();
  private float mMaxOffset = -25.0F;
  private float yW = -0.1F;
  private float yX = 0.8F;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
  }
  
  private void a(View paramView, Transformation paramTransformation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramTransformation.clear();
    paramTransformation.setTransformationType(3);
    Matrix localMatrix = paramTransformation.getMatrix();
    int i = paramView.getWidth();
    int m = paramView.getHeight();
    this.mCamera.save();
    this.mCamera.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    if ((!Build.MODEL.equals("HUAWEI Y325-T00")) && (!Build.MODEL.equals("Lenovo A318t")) && (!Build.MODEL.equals("Lenovo A308t")) && (!Build.MODEL.equals("Lenovo A269")) && (!Build.MODEL.equals("PRA-TL10")) && (!Build.MODEL.equals("HUAWEI CAZ-TL10")) && (!Build.MODEL.equals("BLN-TL10")) && (!auB())) {
      this.mCamera.rotateX(paramFloat1);
    }
    this.mCamera.translate(0.0F, 0.0F, paramFloat2);
    this.mCamera.getMatrix(localMatrix);
    localMatrix.preSkew(paramFloat3, 0.0F);
    localMatrix.preTranslate(paramFloat5, 0.0F);
    localMatrix.preTranslate(-i / 2, -m / 2);
    localMatrix.postTranslate(i / 2, m / 2);
    this.mCamera.restore();
  }
  
  public static boolean auB()
  {
    if ((Build.MODEL.equals("VKY-AL00")) && (Build.VERSION.SDK_INT == 24)) {}
    while ((Build.MODEL.equals("NXT-AL10")) && (Build.VERSION.SDK_INT == 24)) {
      return true;
    }
    return false;
  }
  
  private float e(View paramView)
  {
    int i = getCenterOfView(paramView);
    float f2 = (this.dtQ - i) / this.dtQ * this.dyg;
    float f1;
    if (f2 > this.dyg) {
      f1 = this.dyg;
    }
    do
    {
      return f1;
      f1 = f2;
    } while (f2 >= -this.dyg);
    return -this.dyg;
  }
  
  private float f(View paramView)
  {
    int i = getCenterOfView(paramView);
    if (i < this.dtQ) {
      return i / this.dtQ * this.cFu;
    }
    if (i > this.dtQ) {
      return (this.dtQ * 2 - i) / this.dtQ * this.cFu;
    }
    return this.cFu;
  }
  
  private float g(View paramView)
  {
    float f = this.yX;
    return (1.0F - Math.abs(getCenterOfView(paramView) - this.dtQ) / this.dtQ) * this.yX;
  }
  
  private int getCenterOfCoverflow()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  private int getCenterOfView(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private float h(View paramView)
  {
    int i = getCenterOfView(paramView);
    if (this.yW == -0.1F) {
      return (this.dtQ - i) / this.dtQ * this.yW;
    }
    return (this.dtQ - i) / this.dtQ * this.yW;
  }
  
  private float i(View paramView)
  {
    float f = 0.0F;
    int i = getCenterOfView(paramView);
    if (this.czD) {
      f = Math.abs(this.dtQ - i) / this.dtQ * this.mMaxOffset;
    }
    return f;
  }
  
  private void initialize(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, mP);
    this.k = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, mP);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.cFu = -40;
    }
    ViewCompat.setImportantForAccessibility(this, 2);
  }
  
  public boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = e(paramView);
    float f2 = f(paramView);
    float f3 = h(paramView);
    float f4 = i(paramView);
    a(paramView, paramTransformation, f1, f2, f3, g(paramView), f4);
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.dtQ = getCenterOfCoverflow();
    paramInt2 = getCenterOfGallery();
    View localView = getChildAt(0);
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 50)
    {
      paramInt2 -= paramInt1 / 2;
      this.cz.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.dtQ = getCenterOfCoverflow();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dtQ = getCenterOfCoverflow();
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
  
  public void selectionChanged()
  {
    super.selectionChanged();
    playSoundEffect(0);
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.czD = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.dyg = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.yW = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */