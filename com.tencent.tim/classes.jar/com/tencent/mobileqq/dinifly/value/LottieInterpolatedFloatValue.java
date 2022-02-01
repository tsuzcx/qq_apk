package com.tencent.mobileqq.dinifly.value;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class LottieInterpolatedFloatValue
  extends LottieInterpolatedValue<Float>
{
  public LottieInterpolatedFloatValue(Float paramFloat1, Float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  public LottieInterpolatedFloatValue(Float paramFloat1, Float paramFloat2, Interpolator paramInterpolator)
  {
    super(paramFloat1, paramFloat2, paramInterpolator);
  }
  
  Float interpolateValue(Float paramFloat1, Float paramFloat2, float paramFloat)
  {
    return Float.valueOf(MiscUtils.lerp(paramFloat1.floatValue(), paramFloat2.floatValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieInterpolatedFloatValue
 * JD-Core Version:    0.7.0.1
 */