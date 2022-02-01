package com.tencent.qqmail.bottle.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;

final class BottleConversationReply$2
  implements Animation.AnimationListener
{
  BottleConversationReply$2(Runnable paramRunnable, ListView paramListView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$animationEnd.run();
    this.val$listview.setEnabled(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleConversationReply.2
 * JD-Core Version:    0.7.0.1
 */