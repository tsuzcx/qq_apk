package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class FriendProfileImageActivity$13
  implements Runnable
{
  FriendProfileImageActivity$13(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    this.this$0.animated = false;
    if (!this.this$0.aWH) {
      this.this$0.gE.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.this$0.getResources().getDimension(2131297969), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.this$0.gF.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.13
 * JD-Core Version:    0.7.0.1
 */