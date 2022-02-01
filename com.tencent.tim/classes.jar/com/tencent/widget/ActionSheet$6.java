package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import ausj;
import ausj.f;

public class ActionSheet$6
  implements Runnable
{
  public ActionSheet$6(ausj paramausj) {}
  
  public void run()
  {
    if (ausj.a(this.this$0) != null) {
      ausj.a(this.this$0).onPreShow();
    }
    ausj.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, ausj.a(this.this$0).getHeight(), 0.0F));
    ausj.a(this.this$0).setFillEnabled(true);
    ausj.a(this.this$0).setStartTime(300L);
    ausj.a(this.this$0).setDuration(ausj.a(this.this$0));
    ausj.a(this.this$0, true);
    ausj.a(this.this$0).startAnimation(ausj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */