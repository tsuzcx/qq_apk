package com.tencent.qqmail.activity.compose;

import android.view.animation.Animation;
import com.tencent.qqmail.view.animation.AnimationListenerAdapter;

class QMComposeMailView$9
  extends AnimationListenerAdapter
{
  QMComposeMailView$9(QMComposeMailView paramQMComposeMailView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMComposeMailView.access$300(this.this$0).setVisibility(0);
    QMComposeMailView.access$300(this.this$0).clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.9
 * JD-Core Version:    0.7.0.1
 */