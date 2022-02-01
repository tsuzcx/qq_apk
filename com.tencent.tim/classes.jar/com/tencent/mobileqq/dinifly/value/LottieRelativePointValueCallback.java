package com.tencent.mobileqq.dinifly.value;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class LottieRelativePointValueCallback
  extends LottieValueCallback<PointF>
{
  private final PointF point = new PointF();
  
  public LottieRelativePointValueCallback() {}
  
  public LottieRelativePointValueCallback(@NonNull PointF paramPointF)
  {
    super(paramPointF);
  }
  
  public PointF getOffset(LottieFrameInfo<PointF> paramLottieFrameInfo)
  {
    if (this.value == null) {
      throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
    return (PointF)this.value;
  }
  
  public final PointF getValue(LottieFrameInfo<PointF> paramLottieFrameInfo)
  {
    this.point.set(MiscUtils.lerp(((PointF)paramLottieFrameInfo.getStartValue()).x, ((PointF)paramLottieFrameInfo.getEndValue()).x, paramLottieFrameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(((PointF)paramLottieFrameInfo.getStartValue()).y, ((PointF)paramLottieFrameInfo.getEndValue()).y, paramLottieFrameInfo.getInterpolatedKeyframeProgress()));
    paramLottieFrameInfo = getOffset(paramLottieFrameInfo);
    this.point.offset(paramLottieFrameInfo.x, paramLottieFrameInfo.y);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieRelativePointValueCallback
 * JD-Core Version:    0.7.0.1
 */