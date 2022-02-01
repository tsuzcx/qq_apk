package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableTextFrame
  extends BaseAnimatableValue<DocumentData, DocumentData>
{
  public AnimatableTextFrame(List<Keyframe<DocumentData>> paramList)
  {
    super(paramList);
  }
  
  public TextKeyframeAnimation createAnimation()
  {
    return new TextKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame
 * JD-Core Version:    0.7.0.1
 */