package com.tencent.mobileqq.apollo.view;

import abzv;
import abzw;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class ApolloGameViewBinder$GameListAdapter$2$1$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$2$1$1(abzv paramabzv) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new abzw(this));
    this.a.a.xQ.setVisibility(0);
    this.a.a.xQ.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */