package com.tencent.qqmail.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class QMReadMailView$2
  implements Animation.AnimationListener
{
  QMReadMailView$2(QMReadMailView paramQMReadMailView, Animation.AnimationListener paramAnimationListener) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QMReadMailView.access$000(this.this$0) != null)
    {
      QMReadMailView.access$000(this.this$0).setVisibility(8);
      QMReadMailView.access$002(this.this$0, null);
    }
    if (this.val$listener != null) {
      this.val$listener.onAnimationEnd(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.val$listener != null) {
      this.val$listener.onAnimationRepeat(paramAnimation);
    }
    if (QMReadMailView.access$000(this.this$0) != null) {
      this.this$0.removeView(QMReadMailView.access$000(this.this$0));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.val$listener != null) {
      this.val$listener.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.2
 * JD-Core Version:    0.7.0.1
 */