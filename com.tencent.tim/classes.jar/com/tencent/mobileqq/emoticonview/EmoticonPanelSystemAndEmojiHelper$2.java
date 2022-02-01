package com.tencent.mobileqq.emoticonview;

import afno;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class EmoticonPanelSystemAndEmojiHelper$2
  implements Runnable
{
  public EmoticonPanelSystemAndEmojiHelper$2(afno paramafno) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.this$0.a.yP, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.this$0.a.yP, "alpha", new float[] { 1.0F, 0.6F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.this$0.a.yP, "rotation", new float[] { 0.0F, 50.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.this$0.a.yP, "alpha", new float[] { 0.6F, 1.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.this$0.a.yP, "rotation", new float[] { 50.0F, 0.0F });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator3.setDuration(400L);
    localObjectAnimator3.setInterpolator(new LinearInterpolator());
    localObjectAnimator4.setDuration(400L);
    localObjectAnimator4.setInterpolator(new LinearInterpolator());
    localObjectAnimator5.setDuration(400L);
    localObjectAnimator5.setInterpolator(new LinearInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator4).after(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator5).after(localObjectAnimator3);
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator3).after(localObjectAnimator1);
    this.this$0.a.yP.setVisibility(0);
    localAnimatorSet.start();
    this.this$0.a.context.getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", true).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.2
 * JD-Core Version:    0.7.0.1
 */