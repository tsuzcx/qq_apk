package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import aqey;
import ariv;
import ariw;

public class ShaderAnimLayout
  extends RelativeLayout
{
  private Animation ba = new ariv(this);
  private Animation.AnimationListener c = new ariw(this);
  public boolean caK = false;
  private boolean mIsInitial;
  private Path mPath = new Path();
  public float py = 0.0F;
  
  public ShaderAnimLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (!this.mIsInitial)
    {
      this.ba.setDuration(200L);
      this.ba.setInterpolator(new LinearInterpolator());
      this.mIsInitial = true;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.mPath.reset();
    this.mPath.addRect(getWidth() * (1.0F - this.py), 0.0F, getWidth(), getBottom(), Path.Direction.CW);
    try
    {
      paramCanvas.clipPath(this.mPath, Region.Op.INTERSECT);
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aqey.setLayerType(this, 1, null);
      }
    }
  }
  
  public void eiU()
  {
    this.caK = false;
    this.ba.setAnimationListener(null);
    clearAnimation();
    setVisibility(0);
    startAnimation(this.ba);
  }
  
  public void eiV()
  {
    clearAnimation();
    this.ba.setAnimationListener(null);
    this.caK = false;
    setVisibility(0);
    this.py = 1.0F;
  }
  
  public void eiW()
  {
    clearAnimation();
    this.ba.setAnimationListener(null);
    this.caK = true;
    setVisibility(8);
    this.py = 0.0F;
  }
  
  public void eiX()
  {
    this.caK = true;
    clearAnimation();
    this.ba.setAnimationListener(this.c);
    startAnimation(this.ba);
  }
  
  public void eiY()
  {
    setVisibility(8);
  }
  
  public void hide()
  {
    if (getVisibility() == 0)
    {
      this.caK = true;
      clearAnimation();
      this.ba.setAnimationListener(this.c);
      startAnimation(this.ba);
    }
  }
  
  public void show()
  {
    if (getVisibility() != 0)
    {
      this.caK = false;
      this.ba.setAnimationListener(null);
      clearAnimation();
      setVisibility(0);
      startAnimation(this.ba);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout
 * JD-Core Version:    0.7.0.1
 */