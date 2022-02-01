package moai.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

class FragmentManagerImpl$3
  extends FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
{
  FragmentManagerImpl$3(FragmentManagerImpl paramFragmentManagerImpl, View paramView1, Animation paramAnimation, Fragment paramFragment, View paramView2, ViewGroup paramViewGroup)
  {
    super(paramView1, paramAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (this.val$fragment.getAnimatingAway() != null)
    {
      this.val$fragment.setAnimatingAway(null);
      this.this$0.moveToState(this.val$fragment, this.val$fragment.getStateAfterAnimating(), 0, 0, false);
    }
    if (this.val$view != null) {
      this.val$container.postDelayed(new FragmentManagerImpl.3.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */