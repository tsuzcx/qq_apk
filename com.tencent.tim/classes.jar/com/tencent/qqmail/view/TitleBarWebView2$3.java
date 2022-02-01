package com.tencent.qqmail.view;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TitleBarWebView2$3
  implements Animation.AnimationListener
{
  TitleBarWebView2$3(TitleBarWebView2 paramTitleBarWebView2, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Log.d(TitleBarWebView2.TAG, "onAnimationEnd");
    this.val$container.setVisibility(8);
    this.this$0.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.this$0.invalidate();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Log.d(TitleBarWebView2.TAG, "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.TitleBarWebView2.3
 * JD-Core Version:    0.7.0.1
 */