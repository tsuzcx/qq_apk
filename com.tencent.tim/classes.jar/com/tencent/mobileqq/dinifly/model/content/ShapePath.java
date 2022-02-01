package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.ShapeContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class ShapePath
  implements ContentModel
{
  private final boolean hidden;
  private final int index;
  private final String name;
  private final AnimatableShapeValue shapePath;
  
  public ShapePath(String paramString, int paramInt, AnimatableShapeValue paramAnimatableShapeValue, boolean paramBoolean)
  {
    this.name = paramString;
    this.index = paramInt;
    this.shapePath = paramAnimatableShapeValue;
    this.hidden = paramBoolean;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableShapeValue getShapePath()
  {
    return this.shapePath;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new ShapeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapePath
 * JD-Core Version:    0.7.0.1
 */