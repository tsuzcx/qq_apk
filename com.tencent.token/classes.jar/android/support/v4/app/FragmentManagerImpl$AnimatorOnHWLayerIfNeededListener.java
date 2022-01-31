package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener
  extends AnimatorListenerAdapter
{
  View mView;
  
  FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener(View paramView)
  {
    this.mView = paramView;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.mView.setLayerType(0, null);
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mView.setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimatorOnHWLayerIfNeededListener
 * JD-Core Version:    0.7.0.1
 */