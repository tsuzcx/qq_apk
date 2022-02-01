package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ScaleKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.ScaleXY;
import java.util.List;

public class AnimatableScaleValue
  extends BaseAnimatableValue<ScaleXY, ScaleXY>
{
  AnimatableScaleValue()
  {
    this(new ScaleXY(1.0F, 1.0F));
  }
  
  public AnimatableScaleValue(ScaleXY paramScaleXY)
  {
    super(paramScaleXY);
  }
  
  public AnimatableScaleValue(List<Keyframe<ScaleXY>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation()
  {
    return new ScaleKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue
 * JD-Core Version:    0.7.0.1
 */