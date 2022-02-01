package com.tencent.mobileqq.activity.recent;

import aagt;
import aagu;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class AnonymousEntranceView
  extends RelativeLayout
{
  private AnimationSet s;
  private AnimationSet t;
  private ImageView wb;
  private ImageView wc;
  private ImageView wd;
  private ImageView we;
  
  public AnonymousEntranceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AnonymousEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AnonymousEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static int d(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    this.s = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(300L);
    this.s.addAnimation((Animation)localObject);
    localObject = new RotateAnimation(-75.0F, 75.0F, 1, 0.5F, 1, 1.073F);
    ((Animation)localObject).setDuration(1500L);
    this.s.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setStartOffset(1200L);
    this.s.addAnimation((Animation)localObject);
    this.s.setAnimationListener(new aagt(this));
    this.t = new AnimationSet(true);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(400L);
    this.t.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(400L);
    ((Animation)localObject).setStartOffset(400L);
    this.t.addAnimation((Animation)localObject);
    this.t.setAnimationListener(new aagu(this));
    this.wb = new ImageView(getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, d(getContext(), 30.0F), 0, 0);
    this.wb.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wb.setImageResource(2130839757);
    addView(this.wb);
    this.wc = new ImageView(getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    this.wc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wc.setImageResource(2130839758);
    this.wc.setVisibility(4);
    addView(this.wc);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, d(getContext(), 59.0F), 0, 0);
    this.wd = new ImageView(getContext());
    this.wd.setImageResource(2130839759);
    this.wd.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wd.setPadding(0, 0, d(getContext(), 10.0F), 0);
    addView(this.wd);
    this.we = new ImageView(getContext());
    this.we.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.we.setImageResource(2130839760);
    this.we.setPadding(0, 0, d(getContext(), 10.0F), 0);
    this.we.setVisibility(4);
    addView(this.we);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AnonymousEntranceView
 * JD-Core Version:    0.7.0.1
 */