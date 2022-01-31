package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAnimation
  extends Animation
{
  public static final long a = 800L;
  public static final boolean a = false;
  public static final boolean b = true;
  public static final boolean c = false;
  public float a;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private RotateAnimation.InterpolatedTimeListener jdField_a_of_type_ComTencentMobileqqWidgetRotateAnimation$InterpolatedTimeListener;
  private final float b;
  private final float c;
  private final boolean d;
  
  public RotateAnimation(float paramFloat1, float paramFloat2, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Float = 800.0F;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramBoolean;
    this.jdField_a_of_type_Float = paramInt;
    setDuration(800L);
  }
  
  public void a(RotateAnimation.InterpolatedTimeListener paramInterpolatedTimeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRotateAnimation$InterpolatedTimeListener = paramInterpolatedTimeListener;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRotateAnimation$InterpolatedTimeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRotateAnimation$InterpolatedTimeListener.a(paramFloat);
    }
    float f1;
    float f2;
    if (this.d == true)
    {
      f1 = 180.0F;
      f2 = 0.0F;
    }
    for (;;)
    {
      f2 = (f1 - f2) * paramFloat + f2;
      if (paramFloat > 0.5F) {}
      for (;;)
      {
        f1 = f2;
        if (i != 0) {
          f1 = f2 - 180.0F;
        }
        paramFloat = Math.abs(paramFloat - 0.5F);
        f2 = this.jdField_a_of_type_Float;
        paramTransformation = paramTransformation.getMatrix();
        this.jdField_a_of_type_AndroidGraphicsCamera.save();
        this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, (0.5F - paramFloat) * f2);
        this.jdField_a_of_type_AndroidGraphicsCamera.rotateY(f1);
        this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(paramTransformation);
        this.jdField_a_of_type_AndroidGraphicsCamera.restore();
        paramTransformation.preTranslate(-this.b, -this.c);
        paramTransformation.postTranslate(this.b, this.c);
        return;
        if (this.d) {
          break label183;
        }
        f2 = 360.0F;
        f1 = 180.0F;
        break;
        i = 0;
      }
      label183:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateAnimation
 * JD-Core Version:    0.7.0.1
 */