package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class ComposeToolBar$5
  extends AnimatorListenerAdapter
{
  ComposeToolBar$5(ComposeToolBar paramComposeToolBar) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ComposeToolBar.access$002(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ComposeToolBar.access$002(this.this$0, false);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ComposeToolBar.access$002(this.this$0, true);
    ComposeToolBar.access$800(this.this$0).setVisibility(0);
    ComposeToolBar.access$900(this.this$0).setVisibility(0);
    ComposeToolBar.access$1000(this.this$0).setVisibility(0);
    ComposeToolBar.access$1100(this.this$0).setVisibility(0);
    ComposeToolBar.access$800(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$900(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1000(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1100(this.this$0).setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar.5
 * JD-Core Version:    0.7.0.1
 */