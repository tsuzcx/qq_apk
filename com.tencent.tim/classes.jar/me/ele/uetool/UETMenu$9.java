package me.ele.uetool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class UETMenu$9
  extends AnimatorListenerAdapter
{
  UETMenu$9(UETMenu paramUETMenu, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.val$isOpen) {
      UETMenu.access$1700(this.this$0).setVisibility(8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    UETMenu.access$1700(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETMenu.9
 * JD-Core Version:    0.7.0.1
 */