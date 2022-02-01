package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import nhp;
import nhq;

public class ReadInjoyTabDragAnimationView
  extends TabDragAnimationView
{
  private AnimatorSet E;
  private int aYO;
  private int aYP;
  private boolean asn;
  private Drawable cL;
  private int mStyle = 0;
  
  public ReadInjoyTabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean FA()
  {
    return this.dbH;
  }
  
  private a a()
  {
    a locala = new a(null);
    int m = getPaddingLeft();
    int k = getRight() - getLeft() - getPaddingRight();
    int j = getPaddingTop();
    int i = getBottom() - getTop() - getPaddingBottom();
    switch (this.mGravity)
    {
    default: 
      k = (k + m) / 2;
      i = (i + j) / 2;
      m = k - this.mRealWidth / 2;
      k += this.mRealWidth / 2;
      j = i - this.mRealHeight / 2;
      i += this.mRealHeight / 2;
    }
    for (;;)
    {
      locala.startX = m;
      locala.startY = j;
      locala.endX = k;
      locala.endY = i;
      return locala;
      i = (m + k) / 2;
      m = i - this.mRealWidth / 2;
      k = this.mRealWidth / 2 + i;
      i = this.mRealHeight + j;
      continue;
      j = (m + k) / 2;
      m = j - this.mRealWidth / 2;
      k = this.mRealWidth / 2 + j;
      j = i - this.mRealHeight;
      continue;
      i = (i + j) / 2;
      k = m + this.mRealWidth;
      j = i - this.mRealHeight / 2;
      i += this.mRealHeight / 2;
      continue;
      i = (i + j) / 2;
      m = k - this.mRealWidth / 2;
      j = i - this.mRealHeight / 2;
      i += this.mRealHeight / 2;
    }
  }
  
  public int getStyle()
  {
    return this.mStyle;
  }
  
  public void init()
  {
    this.cL = getContext().getResources().getDrawable(2130850295);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    a locala;
    if ((FA()) && (this.asn) && (this.mStyle == 1))
    {
      locala = a();
      if (this.cL != null)
      {
        this.aYO = ((locala.startX + locala.endX) / 2);
        this.aYP = ((locala.startY + locala.endY) / 2);
        this.cL.setBounds(locala.startX, locala.startY, locala.endX, locala.endY);
        this.cL.draw(paramCanvas);
      }
      return;
    }
    if (this.aYO == 0)
    {
      locala = a();
      this.aYO = ((locala.startX + locala.endX) / 2);
      int i = locala.startY;
      this.aYP = ((locala.endY + i) / 2);
    }
    super.onDraw(paramCanvas);
  }
  
  public void pr(boolean paramBoolean)
  {
    if ((!FA()) || (!this.asn) || (this.mStyle != 1)) {
      return;
    }
    if (!paramBoolean)
    {
      setPivotX(this.aYO);
      setPivotY(this.aYP);
      localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      localObjectAnimator4.setStartDelay(700L);
      this.E = new AnimatorSet();
      this.E.setInterpolator(new LinearInterpolator());
      this.E.play(localObjectAnimator1).with(localObjectAnimator2);
      this.E.play(localObjectAnimator2).before(localObjectAnimator3);
      this.E.play(localObjectAnimator3).with(localObjectAnimator4);
      this.E.addListener(new nhp(this));
      this.E.start();
      return;
    }
    setPivotX(this.aYO);
    setPivotY(this.aYP);
    setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
    this.E = new AnimatorSet();
    this.E.play(localObjectAnimator2).with(localObjectAnimator1);
    this.E.addListener(new nhq(this));
    this.E.start();
  }
  
  public void setIsSelect(boolean paramBoolean)
  {
    QLog.d("ReadInjoyTabDragAnimationView", 4, "setIsSelect  : " + paramBoolean);
    this.asn = paramBoolean;
    if (this.E != null)
    {
      this.E.cancel();
      this.E = null;
    }
    invalidate();
  }
  
  public void tA(int paramInt)
  {
    QLog.d("ReadInjoyTabDragAnimationView", 4, "changeStyle  : " + paramInt);
    this.mStyle = paramInt;
    if (this.E != null)
    {
      this.E.cancel();
      this.E = null;
    }
    kxm.aMC = this.mStyle;
    invalidate();
  }
  
  static class a
  {
    int endX;
    int endY;
    int startX;
    int startY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */