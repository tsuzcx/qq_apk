package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import ausj;
import auso;

public class ActionSheet$7
  implements Runnable
{
  public ActionSheet$7(ausj paramausj) {}
  
  public void run()
  {
    ausj.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, ausj.a(this.this$0).getHeight()));
    ausj.a(this.this$0).setDuration(200L);
    ausj.a(this.this$0).setFillAfter(true);
    ausj.a(this.this$0).startAnimation(ausj.a(this.this$0));
    ausj.a(this.this$0).setAnimationListener(new auso(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */