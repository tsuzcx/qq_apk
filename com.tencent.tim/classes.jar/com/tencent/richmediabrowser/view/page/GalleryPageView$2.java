package com.tencent.richmediabrowser.view.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class GalleryPageView$2
  implements Animation.AnimationListener
{
  GalleryPageView$2(GalleryPageView paramGalleryPageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.textView.clearAnimation();
    this.this$0.textView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.GalleryPageView.2
 * JD-Core Version:    0.7.0.1
 */