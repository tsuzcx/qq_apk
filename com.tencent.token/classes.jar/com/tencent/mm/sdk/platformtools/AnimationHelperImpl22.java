package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;

class AnimationHelperImpl22
  implements BackwardSupportUtil.AnimationHelper.IHelper
{
  public void cancelAnimation(View paramView, Animation paramAnimation)
  {
    paramAnimation.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AnimationHelperImpl22
 * JD-Core Version:    0.7.0.1
 */