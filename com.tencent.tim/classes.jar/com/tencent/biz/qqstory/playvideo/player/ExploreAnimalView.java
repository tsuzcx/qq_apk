package com.tencent.biz.qqstory.playvideo.player;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import qkz;
import qla;

public class ExploreAnimalView
  extends RelativeLayout
{
  public EllipsizingTextView a;
  public LinearLayout eP;
  public AlphaAnimation j;
  protected TranslateAnimation r;
  public TranslateAnimation s;
  protected AnimatorSet y;
  
  public ExploreAnimalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(getContext(), 2131562032, this);
    this.eP = ((LinearLayout)super.findViewById(2131375219));
    this.a = ((EllipsizingTextView)super.findViewById(2131381833));
  }
  
  @TargetApi(11)
  public void b(View paramView, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView.setDuration(1200L);
      paramView.setRepeatCount(-1);
      paramView.setRepeatMode(-1);
      this.y = new AnimatorSet();
      this.y.play(paramView);
      this.y.setStartDelay(paramLong);
      this.y.start();
      return;
    }
    paramView.setVisibility(0);
  }
  
  public void boO()
  {
    if (this.r != null) {
      this.r.cancel();
    }
    if (this.s != null) {
      this.s.cancel();
    }
    this.r = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.r.setDuration(200L);
    this.r.setFillAfter(true);
    this.s = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.s.setDuration(300L);
    this.s.setFillAfter(true);
    this.r.setAnimationListener(new qkz(this));
    this.s.setAnimationListener(new qla(this));
    this.eP.startAnimation(this.r);
  }
  
  @TargetApi(11)
  public void cancelAnimation()
  {
    if (this.r != null)
    {
      this.r.cancel();
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.cancel();
      this.s = null;
    }
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (this.y != null))
    {
      this.y.end();
      this.y.cancel();
    }
  }
  
  public void setText(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      boO();
    }
    while (paramInt != 4) {
      return;
    }
    cancelAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView
 * JD-Core Version:    0.7.0.1
 */