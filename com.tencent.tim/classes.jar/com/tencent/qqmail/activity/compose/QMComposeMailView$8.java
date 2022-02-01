package com.tencent.qqmail.activity.compose;

import android.view.animation.Animation;
import com.tencent.qqmail.view.animation.AnimationListenerAdapter;

class QMComposeMailView$8
  extends AnimationListenerAdapter
{
  QMComposeMailView$8(QMComposeMailView paramQMComposeMailView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMComposeMailView.access$300(this.this$0).setVisibility(8);
    QMComposeMailView.access$300(this.this$0).clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.8
 * JD-Core Version:    0.7.0.1
 */