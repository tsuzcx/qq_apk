package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import jxq;
import jxr;

public class AdControlView
  extends RelativeLayout
{
  private ValueAnimator B;
  private AdvertisementSplitedProgressBar a;
  public boolean acO;
  public boolean acP;
  public boolean acQ;
  private View jf;
  private View jg;
  private View jh;
  private View ji;
  private View jj;
  private int mMode = 1;
  
  public AdControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
    pm();
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131559433, this);
    this.jf = findViewById(2131381633);
    this.jg = findViewById(2131381873);
    this.jh = findViewById(2131362132);
    this.ji = findViewById(2131362144);
    this.jj = findViewById(2131371943);
    this.a = ((AdvertisementSplitedProgressBar)findViewById(2131381811));
    this.jf.setContentDescription(getResources().getString(2131719450));
    this.jg.setContentDescription(getResources().getString(2131701667));
    this.jh.setContentDescription(getResources().getString(2131689617));
    this.ji.setContentDescription(getResources().getString(2131693966));
    this.jj.setContentDescription(getResources().getString(2131689617));
  }
  
  private void pm()
  {
    this.B = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F, 1.0F }).setDuration(1000L);
    this.B.setInterpolator(new DecelerateInterpolator());
    this.B.setRepeatCount(3);
    this.B.addUpdateListener(new jxq(this));
    this.B.addListener(new jxr(this));
  }
  
  public AdvertisementSplitedProgressBar a()
  {
    return this.a;
  }
  
  public void aBa()
  {
    this.acP = true;
    this.jg.setVisibility(0);
    this.jg.setBackgroundResource(2130842439);
    this.B.start();
    this.acO = true;
  }
  
  public void aBb()
  {
    if ((this.acP) || (this.B.isRunning()))
    {
      this.B.cancel();
      this.jg.setAlpha(1.0F);
    }
  }
  
  public View aa()
  {
    return this.jf;
  }
  
  public View ab()
  {
    return this.jg;
  }
  
  public View ac()
  {
    return this.jh;
  }
  
  public View ad()
  {
    return this.ji;
  }
  
  public View ae()
  {
    return this.jj;
  }
  
  public void destory()
  {
    this.acO = false;
  }
  
  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {
      if (this.mMode == 2)
      {
        this.jf.setVisibility(0);
        this.jh.setVisibility(4);
        this.ji.setVisibility(4);
        this.jg.setVisibility(4);
        this.a.setVisibility(4);
        this.jj.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.acP) {
        this.jg.setVisibility(0);
      }
      return;
      this.jf.setVisibility(0);
      this.jh.setVisibility(0);
      this.ji.setVisibility(0);
      this.jj.setVisibility(4);
      this.jg.setVisibility(0);
      this.a.setVisibility(0);
      super.setVisibility(paramInt);
      continue;
      if (paramInt == 4)
      {
        if (this.mMode == 2)
        {
          this.jf.setVisibility(0);
          this.jh.setVisibility(4);
          this.ji.setVisibility(4);
          this.jg.setVisibility(4);
          this.a.setVisibility(4);
          this.jj.setVisibility(0);
        }
        else if (this.acQ)
        {
          this.jf.setVisibility(0);
          this.jh.setVisibility(0);
          this.ji.setVisibility(0);
          this.jg.setVisibility(0);
          this.a.setVisibility(0);
          this.jj.setVisibility(4);
        }
        else
        {
          this.jf.setVisibility(4);
          this.jh.setVisibility(4);
          this.ji.setVisibility(4);
          this.jg.setVisibility(4);
          this.a.setVisibility(4);
          this.jj.setVisibility(4);
        }
      }
      else {
        super.setVisibility(paramInt);
      }
    }
  }
  
  public boolean yN()
  {
    return this.acO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView
 * JD-Core Version:    0.7.0.1
 */