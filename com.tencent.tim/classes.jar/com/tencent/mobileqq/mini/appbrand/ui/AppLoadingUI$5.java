package com.tencent.mobileqq.mini.appbrand.ui;

import android.view.animation.AnimationSet;
import android.widget.TextView;

class AppLoadingUI$5
  implements Runnable
{
  AppLoadingUI$5(AppLoadingUI paramAppLoadingUI, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    AppLoadingUI.access$300(this.this$0).setVisibility(0);
    AppLoadingUI.access$300(this.this$0).setAnimation(this.val$nameAniSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.5
 * JD-Core Version:    0.7.0.1
 */