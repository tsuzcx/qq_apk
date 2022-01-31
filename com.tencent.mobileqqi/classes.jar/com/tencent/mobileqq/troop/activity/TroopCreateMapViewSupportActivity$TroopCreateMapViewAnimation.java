package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

public class TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation
  extends Animation
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  public TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation(TroopCreateMapViewSupportActivity paramTroopCreateMapViewSupportActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt2 - paramInt1);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int + this.b * paramFloat));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation
 * JD-Core Version:    0.7.0.1
 */