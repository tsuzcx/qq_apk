package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.RepeaterContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class Repeater
  implements ContentModel
{
  private final AnimatableFloatValue copies;
  private final boolean hidden;
  private final String name;
  private final AnimatableFloatValue offset;
  private final AnimatableTransform transform;
  
  public Repeater(String paramString, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableTransform paramAnimatableTransform, boolean paramBoolean)
  {
    this.name = paramString;
    this.copies = paramAnimatableFloatValue1;
    this.offset = paramAnimatableFloatValue2;
    this.transform = paramAnimatableTransform;
    this.hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getCopies()
  {
    return this.copies;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableFloatValue getOffset()
  {
    return this.offset;
  }
  
  public AnimatableTransform getTransform()
  {
    return this.transform;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  @Nullable
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RepeaterContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.Repeater
 * JD-Core Version:    0.7.0.1
 */