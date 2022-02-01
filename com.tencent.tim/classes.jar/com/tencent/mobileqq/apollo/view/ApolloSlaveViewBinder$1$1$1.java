package com.tencent.mobileqq.apollo.view;

import acbd;
import acbe;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class ApolloSlaveViewBinder$1$1$1
  implements Runnable
{
  public ApolloSlaveViewBinder$1$1$1(acbd paramacbd) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new acbe(this));
    this.a.a.xQ.setVisibility(0);
    this.a.a.xQ.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloSlaveViewBinder.1.1.1
 * JD-Core Version:    0.7.0.1
 */