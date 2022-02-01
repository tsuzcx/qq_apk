package com.tencent.qqmini.sdk.launcher;

import android.view.animation.AnimationSet;
import android.widget.TextView;

class AppUIProxy$LoadingUI$3
  implements Runnable
{
  AppUIProxy$LoadingUI$3(AppUIProxy.LoadingUI paramLoadingUI, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    AppUIProxy.LoadingUI.access$300(this.this$1).setVisibility(0);
    AppUIProxy.LoadingUI.access$300(this.this$1).setAnimation(this.val$nameAniSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI.3
 * JD-Core Version:    0.7.0.1
 */