package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import nsu;
import nsv;
import wja;

public class ReadInJoyColorBandEntranceButton
  extends ColorBandVideoEntranceButton
{
  private int bck = 0;
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void baK()
  {
    if (this.bck == 0) {
      super.baK();
    }
    do
    {
      return;
      if (this.bck == 1)
      {
        i = getResources().getInteger(2131427371);
        this.f.setImageDrawable(getResources().getDrawable(2130850233));
        this.f.setVisibility(0);
        localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.la, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.la, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.la, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.f, "translationX", new float[] { 0.0F, -wja.dp2px(58.0F, getResources()) }), ObjectAnimator.ofFloat(this.f, "translationY", new float[] { 0.0F, wja.dp2px(54.0F, getResources()) }) });
        localAnimatorSet.setDuration(i);
        localAnimatorSet.addListener(new nsu(this));
        localAnimatorSet.start();
        return;
      }
    } while (this.bck != 2);
    int i = getResources().getInteger(2131427372);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.lb, "rotation", new float[] { 0.0F, 360.0F }) });
    setClickable(false);
    localAnimatorSet.addListener(new nsv(this));
    localAnimatorSet.setDuration(i);
    localAnimatorSet.start();
  }
  
  public void setClickAnimMode(int paramInt)
  {
    this.bck = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton
 * JD-Core Version:    0.7.0.1
 */