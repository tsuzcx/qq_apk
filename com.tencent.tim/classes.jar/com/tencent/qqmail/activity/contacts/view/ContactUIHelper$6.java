package com.tencent.qqmail.activity.contacts.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ContactUIHelper$6
  implements Animation.AnimationListener
{
  ContactUIHelper$6(Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$onComplete != null) {
      this.val$onComplete.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactUIHelper.6
 * JD-Core Version:    0.7.0.1
 */