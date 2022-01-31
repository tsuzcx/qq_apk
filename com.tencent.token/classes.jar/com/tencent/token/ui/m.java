package com.tencent.token.ui;

import android.view.animation.TranslateAnimation;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.RecommendView;

class m
  implements Runnable
{
  m(AccountPageActivity paramAccountPageActivity, int paramInt) {}
  
  public void run()
  {
    AccountPageActivity.access$3300(this.b).setAnimationListener(new n(this));
    if ((!AccountPageActivity.access$1300(this.b)) && (!RqdApplication.b)) {
      AccountPageActivity.access$3200(this.b).startAnimation(AccountPageActivity.access$3300(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.m
 * JD-Core Version:    0.7.0.1
 */