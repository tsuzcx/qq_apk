package com.tencent.qqmail.activity.readmail;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class MailDeleteAnimation$1
  implements Animation.AnimationListener
{
  MailDeleteAnimation$1(MailDeleteAnimation paramMailDeleteAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    MailDeleteAnimation.access$000(this.this$0).setVisibility(8);
    if (MailDeleteAnimation.access$100(this.this$0) != null) {
      MailDeleteAnimation.access$100(this.this$0).run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.MailDeleteAnimation.1
 * JD-Core Version:    0.7.0.1
 */