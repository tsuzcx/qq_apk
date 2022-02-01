package com.tencent.qqmini.miniapp.core.page;

import android.animation.ValueAnimator;
import android.view.View;

class PageWebviewContainer$7$1
  implements Runnable
{
  PageWebviewContainer$7$1(PageWebviewContainer.7 param7, ValueAnimator paramValueAnimator) {}
  
  public void run()
  {
    this.this$1.val$pageWebview.getView().scrollTo(0, ((Integer)this.val$animation.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.7.1
 * JD-Core Version:    0.7.0.1
 */