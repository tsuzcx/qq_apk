package com.tencent.mobileqq.apollo.view;

import abzq.a;
import abzq.a.a;
import abzv;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ApolloGameViewBinder$GameListAdapter$2
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$2(abzq.a parama, ImageView paramImageView, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup, abzq.a.a parama1) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new abzv(this));
    this.xQ.setVisibility(0);
    this.xQ.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2
 * JD-Core Version:    0.7.0.1
 */