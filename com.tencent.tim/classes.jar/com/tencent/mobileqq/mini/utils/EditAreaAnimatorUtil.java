package com.tencent.mobileqq.mini.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class EditAreaAnimatorUtil
{
  public static final int EDIT_DURATION = 100;
  
  public static void editAreaAnimator(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat3, paramFloat4 });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    localAnimatorSet.addListener(new EditAreaAnimatorUtil.1());
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil
 * JD-Core Version:    0.7.0.1
 */