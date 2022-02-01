package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import igd;
import jch;

public class QQLogo
  extends ImageView
{
  private boolean Xu;
  private boolean Xv;
  
  public QQLogo(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQLogo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQLogo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void atA()
  {
    igd.aJ("QQLogo", "dispearLogo:");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new jch(this));
    clearAnimation();
    startAnimation(localAlphaAnimation);
  }
  
  private void atx()
  {
    boolean bool = false;
    this.Xu = false;
    int i = getResources().getDimensionPixelSize(2131298382);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder().append("dispearLogo_internal:");
    if (localLayoutParams.bottomMargin != i) {
      bool = true;
    }
    igd.aJ("QQLogo", bool + "|" + localLayoutParams.bottomMargin + "|" + i);
    if (localLayoutParams.bottomMargin != i)
    {
      setVisibility(8);
      return;
    }
    atA();
  }
  
  private void aty()
  {
    this.Xu = true;
    igd.aJ("QQLogo", "showLogo_internal:");
    atz();
  }
  
  private void atz()
  {
    igd.aJ("QQLogo", "showLogo:");
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f = ((Transformation)localObject).getAlpha();
    clearAnimation();
    localObject = new AlphaAnimation(f, 1.0F);
    ((AlphaAnimation)localObject).setDuration(800L);
    startAnimation((Animation)localObject);
    setVisibility(0);
  }
  
  private void jW(boolean paramBoolean)
  {
    igd.aJ("QQLogo", "QQLogo:" + this.Xu + "|" + paramBoolean + "|" + getVisibility());
    if ((getVisibility() == 8) && (!this.Xu) && (paramBoolean)) {
      aty();
    }
    while ((getVisibility() != 0) || (!this.Xu) || (paramBoolean)) {
      return;
    }
    atx();
  }
  
  public void setQQLogo(boolean paramBoolean, int paramInt)
  {
    if (this.Xv) {}
    do
    {
      return;
      if ((paramInt == 2) || (paramInt == 4))
      {
        jW(paramBoolean);
        return;
      }
    } while (getVisibility() != 0);
    igd.aJ("QQLogo", "setOffset audio hide qq logo");
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QQLogo
 * JD-Core Version:    0.7.0.1
 */