package com.tencent.qqmail.activity.setting;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingAboutActivity$4$1
  implements Animator.AnimatorListener
{
  SettingAboutActivity$4$1(SettingAboutActivity.4 param4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SettingAboutActivity.access$500(this.this$1.this$0).post(new SettingAboutActivity.4.1.1(this));
    SettingAboutActivity.access$500(this.this$1.this$0).setClickable(true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SettingAboutActivity.access$500(this.this$1.this$0).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.4.1
 * JD-Core Version:    0.7.0.1
 */