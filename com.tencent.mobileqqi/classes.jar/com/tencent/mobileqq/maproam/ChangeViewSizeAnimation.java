package com.tencent.mobileqq.maproam;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ChangeViewSizeAnimation
  extends Animation
{
  final int jdField_a_of_type_Int;
  final View jdField_a_of_type_AndroidViewView;
  final int b;
  final int c;
  final int d;
  
  public ChangeViewSizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt2 - paramInt1);
    this.c = paramInt3;
    this.d = (paramInt4 - paramInt3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramTransformation != null)
    {
      paramTransformation.width = ((int)(this.jdField_a_of_type_Int + this.b * paramFloat));
      paramTransformation.height = ((int)(this.c + this.d * paramFloat));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.ChangeViewSizeAnimation
 * JD-Core Version:    0.7.0.1
 */