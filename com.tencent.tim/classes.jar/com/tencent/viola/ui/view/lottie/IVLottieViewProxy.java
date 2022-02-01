package com.tencent.viola.ui.view.lottie;

import android.animation.Animator.AnimatorListener;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;

public abstract interface IVLottieViewProxy
{
  public abstract void v_addAnimatorListener(Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void v_cancelAnimation();
  
  public abstract void v_loop(boolean paramBoolean);
  
  public abstract void v_pauseAnimation();
  
  public abstract void v_playAnimation();
  
  public abstract void v_removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void v_resumeAnimation();
  
  public abstract void v_setAnimation(String paramString, VLottie.IVLottieLoadListener paramIVLottieLoadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.lottie.IVLottieViewProxy
 * JD-Core Version:    0.7.0.1
 */