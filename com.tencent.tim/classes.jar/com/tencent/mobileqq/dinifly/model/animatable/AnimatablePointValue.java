package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.PointKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatablePointValue
  extends BaseAnimatableValue<PointF, PointF>
{
  public AnimatablePointValue(List<Keyframe<PointF>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    return new PointKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue
 * JD-Core Version:    0.7.0.1
 */