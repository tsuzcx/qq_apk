package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener
  extends FragmentManagerImpl.AnimationListenerWrapper
{
  View mView;
  
  FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    super(paramAnimationListener, null);
    this.mView = paramView;
  }
  
  @CallSuper
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((ViewCompat.isAttachedToWindow(this.mView)) || (Build.VERSION.SDK_INT >= 24)) {
      this.mView.post(new FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.1(this));
    }
    for (;;)
    {
      super.onAnimationEnd(paramAnimation);
      return;
      this.mView.setLayerType(0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
 * JD-Core Version:    0.7.0.1
 */