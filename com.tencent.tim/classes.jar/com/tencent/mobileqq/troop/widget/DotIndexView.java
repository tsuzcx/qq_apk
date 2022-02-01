package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DotIndexView
  extends LinearLayout
{
  protected int dWJ = 2130844698;
  protected int dWK;
  protected int dWL = 8;
  protected LinearLayout kY;
  protected Context mContext;
  
  public DotIndexView(Context paramContext)
  {
    super(paramContext);
    this.kY = new LinearLayout(paramContext);
    this.mContext = this.kY.getContext();
  }
  
  public DotIndexView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.kY = new LinearLayout(paramContext);
    this.mContext = this.kY.getContext();
    ka(0, paramInt);
  }
  
  public DotIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kY = new LinearLayout(paramContext);
    this.mContext = this.kY.getContext();
  }
  
  private void Sj(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(this.dWL, 0, this.dWL, 0);
    localLayoutParams.gravity = 17;
    localImageView.setLayoutParams(localLayoutParams);
    try
    {
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(this.dWJ));
      if (paramBoolean) {
        localImageView.setSelected(true);
      }
      this.kY.addView(localImageView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localImageView.setImageResource(2130844698);
      }
    }
  }
  
  public void ka(int paramInt1, int paramInt2)
  {
    if ((this.kY == null) || (paramInt2 != this.dWK))
    {
      removeAllViews();
      this.kY = new LinearLayout(this.mContext);
      this.kY.setOrientation(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.kY.setLayoutParams(localLayoutParams);
      int i = 0;
      if (i < paramInt2)
      {
        if (i == paramInt1) {
          Sj(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Sj(false);
        }
      }
      this.dWK = paramInt2;
      addView(this.kY);
    }
  }
  
  public void setDotDrawable(int paramInt)
  {
    if (this.dWJ != paramInt)
    {
      this.dWJ = paramInt;
      if ((this.kY != null) && (this.dWK != 0))
      {
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.dWJ);
        paramInt = 0;
        while (paramInt < this.dWK)
        {
          View localView = this.kY.getChildAt(paramInt);
          if ((localView != null) && ((localView instanceof ImageView))) {
            ((ImageView)localView).setImageDrawable(localDrawable);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void setDotSelected(int paramInt, boolean paramBoolean)
  {
    if (this.kY == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        int i = 0;
        while (i < this.dWK)
        {
          if (this.kY.getChildAt(i) != null) {
            this.kY.getChildAt(i).setSelected(false);
          }
          i += 1;
        }
      }
    } while (this.kY.getChildAt(paramInt) == null);
    this.kY.getChildAt(paramInt).setSelected(paramBoolean);
  }
  
  public void setMargin(int paramInt)
  {
    this.dWL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.DotIndexView
 * JD-Core Version:    0.7.0.1
 */