package com.tencent.viola.ui.view.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.View;
import com.tencent.viola.ui.component.VLottie;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VLottieView
  extends View
  implements IVView<VLottie>
{
  WeakReference<VLottie> mWeakReference;
  IVLottieViewProxy vLottieViewProxy;
  
  public VLottieView(Context paramContext)
  {
    super(paramContext);
    this.vLottieViewProxy = Factory.createVLottieView(paramContext);
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_addAnimatorListener(paramAnimatorListener);
    }
  }
  
  public void bindComponent(VLottie paramVLottie)
  {
    this.mWeakReference = new WeakReference(paramVLottie);
  }
  
  public void cancelAnimation()
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_cancelAnimation();
    }
  }
  
  public VLottie getComponent()
  {
    if (this.mWeakReference != null) {
      return (VLottie)this.mWeakReference.get();
    }
    return null;
  }
  
  public View getRealView()
  {
    if ((this.vLottieViewProxy != null) && ((this.vLottieViewProxy instanceof View))) {
      return (View)this.vLottieViewProxy;
    }
    return new View(getContext());
  }
  
  public void loop(boolean paramBoolean)
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_loop(paramBoolean);
    }
  }
  
  public void pauseAnimation()
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_pauseAnimation();
    }
  }
  
  public void playAnimation()
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_playAnimation();
    }
  }
  
  public void resumeAnimation()
  {
    if (this.vLottieViewProxy != null) {
      this.vLottieViewProxy.v_resumeAnimation();
    }
  }
  
  public static class Factory
  {
    private static IVlottieViewCreater vlottieViewCreater;
    
    public static IVLottieViewProxy createVLottieView(Context paramContext)
    {
      if (vlottieViewCreater != null) {
        return vlottieViewCreater.createLottieView(paramContext);
      }
      return null;
    }
    
    public static void setVLottieViewCreater(IVlottieViewCreater paramIVlottieViewCreater)
    {
      vlottieViewCreater = paramIVlottieViewCreater;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.lottie.VLottieView
 * JD-Core Version:    0.7.0.1
 */