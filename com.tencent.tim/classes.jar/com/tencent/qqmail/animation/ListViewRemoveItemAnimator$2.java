package com.tencent.qqmail.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;

final class ListViewRemoveItemAnimator$2
  implements Animation.AnimationListener
{
  ListViewRemoveItemAnimator$2(View paramView, int[] paramArrayOfInt, Runnable paramRunnable, ListView paramListView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.setTag(null);
    paramAnimation = this.val$removedViewCount;
    int i = paramAnimation[0] - 1;
    paramAnimation[0] = i;
    if (i == 0)
    {
      this.val$animationEnd.run();
      this.val$listview.setEnabled(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.ListViewRemoveItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */