package com.tencent.qqmini.sdk.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class ActionSheet$5
  implements Runnable
{
  ActionSheet$5(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    ActionSheet.access$902(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheet.access$1000(this.this$0).getHeight()));
    ActionSheet.access$900(this.this$0).setDuration(200L);
    ActionSheet.access$900(this.this$0).setFillAfter(true);
    ActionSheet.access$1000(this.this$0).startAnimation(ActionSheet.access$900(this.this$0));
    ActionSheet.access$900(this.this$0).setAnimationListener(new ActionSheet.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.5
 * JD-Core Version:    0.7.0.1
 */