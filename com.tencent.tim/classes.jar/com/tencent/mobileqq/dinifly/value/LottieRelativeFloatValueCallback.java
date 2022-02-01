package com.tencent.mobileqq.dinifly.value;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class LottieRelativeFloatValueCallback
  extends LottieValueCallback<Float>
{
  public LottieRelativeFloatValueCallback() {}
  
  public LottieRelativeFloatValueCallback(@NonNull Float paramFloat)
  {
    super(paramFloat);
  }
  
  public Float getOffset(LottieFrameInfo<Float> paramLottieFrameInfo)
  {
    if (this.value == null) {
      throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
    return (Float)this.value;
  }
  
  public Float getValue(LottieFrameInfo<Float> paramLottieFrameInfo)
  {
    return Float.valueOf(MiscUtils.lerp(((Float)paramLottieFrameInfo.getStartValue()).floatValue(), ((Float)paramLottieFrameInfo.getEndValue()).floatValue(), paramLottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(paramLottieFrameInfo).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieRelativeFloatValueCallback
 * JD-Core Version:    0.7.0.1
 */