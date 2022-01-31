package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;

class AnimationHelperImpl21below
  implements BackwardSupportUtil.AnimationHelper.IHelper
{
  public void cancelAnimation(View paramView, Animation paramAnimation)
  {
    if (paramView != null) {
      paramView.setAnimation(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AnimationHelperImpl21below
 * JD-Core Version:    0.7.0.1
 */