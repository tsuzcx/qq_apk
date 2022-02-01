package com.tencent.qqmail.utilities.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class AnimUtil$1
  extends Animation
{
  AnimUtil$1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = this.val$startA;
    int j = (int)((this.val$endA - this.val$startA) * paramFloat);
    int k = this.val$startR;
    int m = (int)((this.val$endR - this.val$startR) * paramFloat);
    int n = this.val$startG;
    int i1 = (int)((this.val$endG - this.val$startG) * paramFloat);
    int i2 = this.val$startB;
    int i3 = (int)((this.val$endB - this.val$startB) * paramFloat);
    this.val$view.setBackgroundColor(i + j << 24 | k + m << 16 | n + i1 << 8 | i2 + i3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.animation.AnimUtil.1
 * JD-Core Version:    0.7.0.1
 */