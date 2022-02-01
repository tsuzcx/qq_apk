package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmail.utilities.observer.QMNotification;

class QMToggleView$4
  implements Animation.AnimationListener
{
  QMToggleView$4(QMToggleView paramQMToggleView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$isIn)
    {
      QMToggleView.access$302(this.this$0, false);
      QMToggleView.access$202(this.this$0, false);
      QMToggleView.access$400(this.this$0).setVisibility(0);
      QMNotification.postNotification("accounttoggleviewshow", null);
      return;
    }
    QMToggleView.access$302(this.this$0, true);
    QMToggleView.access$202(this.this$0, false);
    QMToggleView.access$400(this.this$0).setVisibility(8);
    this.this$0.setVisibility(4);
    QMNotification.postNotification("accounttoggleviewhide", null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMToggleView.4
 * JD-Core Version:    0.7.0.1
 */