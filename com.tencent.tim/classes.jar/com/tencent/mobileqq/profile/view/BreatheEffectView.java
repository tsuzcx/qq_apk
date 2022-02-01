package com.tencent.mobileqq.profile.view;

import alga;
import algb;
import algc;
import algd;
import alge;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import aqod.a;
import aqod.b;
import aqod.c;

public class BreatheEffectView
  extends ImageView
  implements aqod.c
{
  private static int dsX;
  public static final int[] mw = { 170, 112, 112 };
  private AnimatorSet au;
  private TypeEvaluator b = new alga(this);
  private Rect cr;
  private LayerDrawable d;
  private Rect[] e;
  private Drawable[] mDrawables;
  private int[] mx;
  
  public BreatheEffectView(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  public BreatheEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  public BreatheEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize();
  }
  
  private boolean aty()
  {
    return (this.d != null) && (getBackground() == this.d);
  }
  
  private void dFD()
  {
    if (this.e == null)
    {
      this.e = new Rect[3];
      int i = 0;
      while (i < 3)
      {
        this.e[i] = new Rect(this.mDrawables[i].getBounds());
        i += 1;
      }
      i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.mDrawables[i];
        Rect localRect = this.e[i];
        int j = localRect.centerX();
        int k = localRect.centerY();
        localDrawable.setBounds(j, k, j, k);
        i += 1;
      }
    }
  }
  
  private void initialize()
  {
    dsX = getResources().getDimensionPixelSize(2131298986);
    setBackgroundResource(2130848282);
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof LayerDrawable))
    {
      this.d = ((LayerDrawable)localDrawable);
      this.mDrawables = new Drawable[3];
      this.mDrawables[2] = this.d.findDrawableByLayerId(2131363407);
      this.mDrawables[1] = this.d.findDrawableByLayerId(2131363408);
      this.mDrawables[0] = this.d.findDrawableByLayerId(2131363400);
      return;
    }
    throw new RuntimeException("Background is not a layer drawable!");
  }
  
  public boolean M(float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (this.cr != null) {
      bool = this.cr.contains((int)paramFloat1, (int)paramFloat2);
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return bool;
      if (this.mx == null)
      {
        this.mx = new int[2];
        getLocationOnScreen(this.mx);
      }
      i = getWidth();
      j = this.mx[0];
      k = getHeight();
      m = this.mx[1];
    } while ((paramFloat1 >= this.mx[0]) && (paramFloat1 <= i + j) && (paramFloat2 >= this.mx[1]) && (paramFloat2 <= k + m));
    return false;
  }
  
  public void a(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    atY();
    dFB();
  }
  
  public void a(a parama)
  {
    if (aty())
    {
      dFC();
      dFD();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.mDrawables[i];
        Object localObject = this.e[i];
        int j = ((Rect)localObject).centerX();
        int k = ((Rect)localObject).centerY();
        Rect localRect = new Rect(j, k, j, k);
        localDrawable.setBounds(localRect);
        localObject = ObjectAnimator.ofObject(this.b, new Object[] { localRect, localObject });
        ((ValueAnimator)localObject).addUpdateListener(new algc(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        ((ValueAnimator)localObject).setStartDelay(i * 50);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        i += 1;
      }
      if (parama != null) {
        localAnimatorSet.addListener(new algd(this, parama));
      }
      localAnimatorSet.setInterpolator(new OvershootInterpolator(1.6F));
      localAnimatorSet.start();
    }
  }
  
  public boolean a(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void atX()
  {
    if (aty())
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int i = 0;
      while (i < 3)
      {
        Object localObject1 = this.mDrawables[i];
        Object localObject2 = this.e[i];
        Object localObject3 = new Rect();
        ((Rect)localObject2).left -= dsX;
        ((Rect)localObject2).top -= dsX;
        ((Rect)localObject2).right += dsX;
        ((Rect)localObject2).bottom += dsX;
        localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.b, new Object[] { localObject2, localObject3 }).setDuration(800L);
        ((ValueAnimator)localObject2).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 204, 0 }).setDuration(800L);
        ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject3 = ObjectAnimator.ofInt(new int[] { 0, 0 });
        ((ValueAnimator)localObject3).setDuration(1000L);
        localAnimatorSet.playTogether(new Animator[] { localObject2, localObject1, localObject3 });
        i += 1;
      }
      localAnimatorSet.start();
    }
  }
  
  public void atY()
  {
    dFC();
  }
  
  public void b(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2) {}
  
  public void b(a parama)
  {
    if (aty())
    {
      clearAnimation();
      parama = new AnimatorSet();
      int i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.mDrawables[i];
        Object localObject = this.e[i];
        int j = ((Rect)localObject).centerX();
        int k = ((Rect)localObject).centerY();
        localObject = ObjectAnimator.ofObject(this.b, new Object[] { localObject, new Rect(j, k, j, k) });
        ((ValueAnimator)localObject).addUpdateListener(new alge(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        parama.playTogether(new Animator[] { localObject });
        i += 1;
      }
      parama.start();
    }
  }
  
  public boolean b(aqod.a parama, aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    atX();
    return true;
  }
  
  public void dFB()
  {
    if (aty())
    {
      if (this.au == null)
      {
        this.au = new AnimatorSet();
        int i = 0;
        while (i < 3)
        {
          Object localObject1 = this.mDrawables[i];
          Object localObject2 = new Rect();
          ((Rect)localObject2).left = (this.e[i].left - dsX);
          ((Rect)localObject2).top = (this.e[i].top - dsX);
          ((Rect)localObject2).right = (this.e[i].right + dsX);
          ((Rect)localObject2).bottom = (this.e[i].bottom + dsX);
          localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.b, new Object[] { this.e[i], localObject2 });
          ((ValueAnimator)localObject2).setStartDelay(i * 180);
          ((ValueAnimator)localObject2).setDuration(600L);
          ((ValueAnimator)localObject2).setInterpolator(new CycleInterpolator(0.5F));
          localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 0, 255 });
          ((ValueAnimator)localObject1).setInterpolator(new CycleInterpolator(0.5F));
          ((ValueAnimator)localObject1).setStartDelay(i * 180);
          ((ValueAnimator)localObject1).setDuration(600L);
          this.au.playTogether(new Animator[] { localObject1 });
          if (2 == i) {
            ((ValueAnimator)localObject2).addListener(new algb(this));
          }
          this.au.playTogether(new Animator[] { localObject2 });
          i += 1;
        }
      }
      this.au.start();
    }
  }
  
  public void dFC()
  {
    if ((aty()) && (this.e != null))
    {
      clearAnimation();
      int i = 0;
      while (i < 3)
      {
        this.mDrawables[i].setBounds(this.e[i]);
        this.mDrawables[i].setAlpha(255);
        i += 1;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    dFD();
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setHaloColor(int paramInt)
  {
    if (this.mDrawables != null)
    {
      int i = 0;
      if (i < 3)
      {
        int j;
        if ((this.mDrawables[i] instanceof GradientDrawable))
        {
          j = mw[i] << 24 | 0xFFFFFF & paramInt;
          if (i == 0) {
            break label65;
          }
          ((GradientDrawable)this.mDrawables[i]).setColor(j);
        }
        for (;;)
        {
          i += 1;
          break;
          label65:
          ((GradientDrawable)this.mDrawables[i]).setStroke(2, j);
        }
      }
    }
  }
  
  public void setHoverHotArea(Rect paramRect)
  {
    this.cr = paramRect;
  }
  
  public static abstract interface a
  {
    public abstract void dFE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView
 * JD-Core Version:    0.7.0.1
 */