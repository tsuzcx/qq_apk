package com.tencent.richmediabrowser.view.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

class GalleryPageView$1
  implements Animation.AnimationListener
{
  GalleryPageView$1(GalleryPageView paramGalleryPageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.textView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.this$0.scene.isAnimating()) {
      this.this$0.textView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.GalleryPageView.1
 * JD-Core Version:    0.7.0.1
 */