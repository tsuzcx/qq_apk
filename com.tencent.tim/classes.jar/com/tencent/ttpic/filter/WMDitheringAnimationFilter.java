package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.ttpic.openapi.model.WMElement;
import java.util.List;

public class WMDitheringAnimationFilter
  extends WMAnimationFilterBase
{
  private static final int ANIMATION_DURATION = 1000;
  private static final int ANIMATION_FRAMES = 16;
  private static final int FRAME_DURATION = 62;
  private static final String TAG = WMDitheringAnimationFilter.class.getSimpleName();
  
  public WMDitheringAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    super(paramWMElement, paramInt1, paramInt2, 1000);
  }
  
  protected void initAnimationTimePoints()
  {
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 0L, 0.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 124L, (float)Math.toRadians(6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 248L, (float)Math.toRadians(-6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 372L, (float)Math.toRadians(6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 496L, (float)Math.toRadians(-6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 620L, (float)Math.toRadians(0.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 992L, (float)Math.toRadians(0.0D)));
  }
  
  protected void setAnimationParams(long paramLong)
  {
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, getAnimationValue(paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMDitheringAnimationFilter
 * JD-Core Version:    0.7.0.1
 */