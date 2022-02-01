package com.tencent.qqmini.miniapp.core.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class PageWebviewContainer$7
  implements ValueAnimator.AnimatorUpdateListener
{
  PageWebviewContainer$7(PageWebviewContainer paramPageWebviewContainer, PageWebview paramPageWebview) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ThreadManager.getUIHandler().post(new PageWebviewContainer.7.1(this, paramValueAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.7
 * JD-Core Version:    0.7.0.1
 */