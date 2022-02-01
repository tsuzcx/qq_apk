package com.tencent.qqmail.bottle.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class BottleConversationReply$1
  extends Animation
{
  BottleConversationReply$1(int paramInt, View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)(this.val$height * paramFloat);
    if (i > 0)
    {
      paramTransformation = this.val$view.getLayoutParams();
      paramTransformation.height = i;
      this.val$view.setLayoutParams(paramTransformation);
      return;
    }
    paramTransformation = this.val$view.getLayoutParams();
    paramTransformation.height = 1;
    this.val$view.setLayoutParams(paramTransformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleConversationReply.1
 * JD-Core Version:    0.7.0.1
 */