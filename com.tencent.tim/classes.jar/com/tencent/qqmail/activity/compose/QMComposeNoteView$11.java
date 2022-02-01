package com.tencent.qqmail.activity.compose;

import android.view.animation.Animation;
import com.tencent.qqmail.view.animation.AnimationListenerAdapter;

class QMComposeNoteView$11
  extends AnimationListenerAdapter
{
  QMComposeNoteView$11(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMComposeNoteView.access$200(this.this$0).setVisibility(0);
    QMComposeNoteView.access$200(this.this$0).clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.11
 * JD-Core Version:    0.7.0.1
 */