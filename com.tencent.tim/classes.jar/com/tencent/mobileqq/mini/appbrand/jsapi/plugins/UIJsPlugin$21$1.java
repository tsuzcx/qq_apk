package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;

class UIJsPlugin$21$1
  implements Runnable
{
  UIJsPlugin$21$1(UIJsPlugin.21 param21, ValueAnimator paramValueAnimator) {}
  
  public void run()
  {
    this.this$1.val$pageWebview.getView().scrollTo(0, ((Integer)this.val$animation.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.21.1
 * JD-Core Version:    0.7.0.1
 */