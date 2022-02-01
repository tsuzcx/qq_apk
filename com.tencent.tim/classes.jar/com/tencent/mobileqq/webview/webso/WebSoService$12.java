package com.tencent.mobileqq.webview.webso;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import ardd;

public final class WebSoService$12
  implements Runnable
{
  WebSoService$12(View paramView, Drawable paramDrawable) {}
  
  public void run()
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.val$view.animate().alpha(0.0F).setDuration(300L);
    localViewPropertyAnimator.setListener(new ardd(this, localViewPropertyAnimator));
    localViewPropertyAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.12
 * JD-Core Version:    0.7.0.1
 */