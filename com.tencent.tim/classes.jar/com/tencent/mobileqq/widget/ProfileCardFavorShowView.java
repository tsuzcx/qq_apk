package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProfileCardFavorShowView
  extends FrameLayout
{
  public ViewGroup bD;
  public ViewGroup eR;
  private int eht = -1;
  public LinearLayout mContentContainer;
  public Context mContext;
  public ViewGroup mTitleBar;
  public TextView mTitleText;
  public ImageView rx;
  
  public ProfileCardFavorShowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.eht = paramInt;
    init();
  }
  
  public int MI()
  {
    return this.mContentContainer.getChildCount();
  }
  
  public View S(int paramInt)
  {
    return this.mContentContainer.getChildAt(paramInt);
  }
  
  public void YC(int paramInt)
  {
    ((LinearLayout.LayoutParams)this.mContentContainer.getLayoutParams()).height = (this.mContentContainer.getPaddingTop() + paramInt + this.mContentContainer.getPaddingBottom());
    invalidate();
  }
  
  public void addView(View paramView)
  {
    this.mContentContainer.addView(paramView);
  }
  
  public LinearLayout getContainer()
  {
    return this.mContentContainer;
  }
  
  protected int getLayout()
  {
    if (this.eht > 0) {
      return this.eht;
    }
    return 2131559705;
  }
  
  protected void init()
  {
    LayoutInflater.from(this.mContext).inflate(getLayout(), this, true);
    this.bD = ((LinearLayout)findViewById(2131377556));
    this.mTitleBar = ((ViewGroup)findViewById(2131365089));
    this.mTitleText = ((TextView)findViewById(2131379562));
    this.rx = ((ImageView)findViewById(2131368865));
    this.mContentContainer = ((LinearLayout)findViewById(2131373646));
    this.eR = ((RelativeLayout)findViewById(2131368273));
    this.mTitleText.setTextColor(getResources().getColorStateList(2131167304));
    this.rx.setImageResource(2130839512);
  }
  
  public void removeAllViews()
  {
    this.mContentContainer.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    if (this.mContentContainer.indexOfChild(paramView) >= 0) {
      this.mContentContainer.removeView(paramView);
    }
  }
  
  public void setMarginBottomEnable(boolean paramBoolean)
  {
    if (this.bD != null) {
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int i = getResources().getDimensionPixelSize(2131297952);; i = 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.bD.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = i;
        this.bD.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void setShowArrow(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.rx != null)
    {
      localImageView = this.rx;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.mTitleBar != null)
    {
      localViewGroup = this.mTitleBar;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.mTitleText != null) {
      this.mTitleText.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorShowView
 * JD-Core Version:    0.7.0.1
 */