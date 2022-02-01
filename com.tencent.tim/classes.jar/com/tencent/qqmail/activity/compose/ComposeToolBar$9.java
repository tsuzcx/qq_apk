package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.qqmail.activity.compose.richeditor.ColorStyleView;

class ComposeToolBar$9
  extends AnimatorListenerAdapter
{
  ComposeToolBar$9(ComposeToolBar paramComposeToolBar) {}
  
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
    ComposeToolBar.access$1300(this.this$0).setVisibility(0);
    ComposeToolBar.access$1400(this.this$0).setVisibility(0);
    ComposeToolBar.access$1500(this.this$0).setVisibility(0);
    ComposeToolBar.access$1600(this.this$0).setVisibility(0);
    ComposeToolBar.access$1100(this.this$0).setVisibility(0);
    ComposeToolBar.access$1300(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1400(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1500(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1600(this.this$0).setAlpha(0.0F);
    ComposeToolBar.access$1100(this.this$0).setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar.9
 * JD-Core Version:    0.7.0.1
 */