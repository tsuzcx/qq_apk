package com.tencent.mobileqq.apollo.store;

import abtl;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class ApolloGuestsStateActivity$3$1
  implements Runnable
{
  public ApolloGuestsStateActivity$3$1(abtl paramabtl) {}
  
  public void run()
  {
    if (this.a.this$0.AT != null)
    {
      TextView localTextView = (TextView)this.a.this$0.AT.findViewById(2131362782);
      localTextView.setVisibility(0);
      Object localObject1 = new AlphaAnimation(1.0F, 0.0F);
      Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -50.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localAnimationSet.setDuration(1000L);
      localAnimationSet.setFillAfter(true);
      localObject1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F });
      localObject2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.5F });
      ApolloGuestsStateActivity.a(this.a.this$0, ObjectAnimator.ofPropertyValuesHolder(this.a.this$0.fC, new PropertyValuesHolder[] { localObject1, localObject2, localPropertyValuesHolder }));
      ApolloGuestsStateActivity.a(this.a.this$0).setDuration(500L);
      localTextView.startAnimation(localAnimationSet);
      ApolloGuestsStateActivity.a(this.a.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.3.1
 * JD-Core Version:    0.7.0.1
 */