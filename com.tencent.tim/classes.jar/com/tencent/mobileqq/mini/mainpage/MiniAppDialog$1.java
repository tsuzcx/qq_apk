package com.tencent.mobileqq.mini.mainpage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MiniAppDialog$1
  implements Animation.AnimationListener
{
  MiniAppDialog$1(MiniAppDialog paramMiniAppDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    MiniAppDialog.access$002(this.this$0, false);
    MiniAppDialog.access$200(this.this$0).post(new MiniAppDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    MiniAppDialog.access$002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MiniAppDialog.1
 * JD-Core Version:    0.7.0.1
 */