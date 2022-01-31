package com.tencent.token.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.RecommendView;

class n
  implements Animation.AnimationListener
{
  n(m paramm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    h.c("onAnimationEnd");
    AccountPageActivity.access$3200(this.a.b).clearAnimation();
    AccountPageActivity.access$3200(this.a.b).layout(this.a.a - (int)AccountPageActivity.access$3200(this.a.b).getViewWidth(), AccountPageActivity.access$3200(this.a.b).getTop(), this.a.a, AccountPageActivity.access$3200(this.a.b).getBottom());
    h.c("w_screen---" + this.a.a + "\nw_screen - (int) mZzbRecomView.getViewWidth()---" + (this.a.a - (int)AccountPageActivity.access$3200(this.a.b).getViewWidth()));
    AccountPageActivity.access$3200(this.a.b).setShowBink(true);
    AccountPageActivity.access$3200(this.a.b).a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AccountPageActivity.access$3200(this.a.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.n
 * JD-Core Version:    0.7.0.1
 */