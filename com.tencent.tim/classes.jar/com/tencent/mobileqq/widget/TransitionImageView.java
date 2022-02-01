package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class TransitionImageView
  extends FrameLayout
  implements Animation.AnimationListener
{
  private Animation bb;
  private Animation bc;
  private URLImageView cb;
  private URLImageView cc;
  private int coy;
  
  public TransitionImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.cb = new URLImageView(paramContext);
    this.cb.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.cc = new URLImageView(paramContext);
    this.cc.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.cb, -1, -1);
    addView(this.cc, -1, -1);
    this.coy = 0;
    this.bb = new AlphaAnimation(0.0F, 1.0F);
    this.bb.setDuration(1500L);
    this.bb.setFillAfter(true);
    this.bb.setAnimationListener(this);
    this.bc = new AlphaAnimation(1.0F, 0.0F);
    this.bc.setDuration(1500L);
    this.bc.setFillAfter(true);
    this.bc.setAnimationListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.bc)
    {
      if (this.coy != 1) {
        break label25;
      }
      this.cc.setImageDrawable(null);
    }
    label25:
    while (this.coy != 2) {
      return;
    }
    this.cb.setImageDrawable(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.coy = 0;
    this.cb.clearAnimation();
    this.cc.clearAnimation();
    this.bb.reset();
    this.bc.reset();
    this.cb.setImageDrawable(paramDrawable);
    this.cc.setImageDrawable(null);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransitionImageView
 * JD-Core Version:    0.7.0.1
 */