package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileCardFavorItemView
  extends LinearLayout
{
  public ImageView FK;
  public View He;
  private Context ctx;
  public ImageView gX;
  public LinearLayout lA;
  private LinearLayout mContainer;
  private View mContentView;
  public TextView mTitle;
  
  public ProfileCardFavorItemView(Context paramContext)
  {
    super(paramContext);
    this.ctx = paramContext;
    init();
  }
  
  public ProfileCardFavorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ctx = paramContext;
    init();
  }
  
  private void init()
  {
    this.mContentView = LayoutInflater.from(this.ctx).inflate(2131559704, this, true);
    this.mTitle = ((TextView)this.mContentView.findViewById(2131369532));
    this.mTitle.setTextColor(getResources().getColorStateList(2131167304));
    this.gX = ((ImageView)this.mContentView.findViewById(2131362978));
    this.mContainer = ((LinearLayout)this.mContentView.findViewById(2131373640));
    this.lA = ((LinearLayout)this.mContentView.findViewById(2131373643));
    this.FK = ((ImageView)this.mContentView.findViewById(2131373641));
    this.He = this.mContentView.findViewById(2131373642);
  }
  
  public void addView(View paramView)
  {
    this.mContainer.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    this.mContainer.addView(paramView, paramInt);
  }
  
  public void removeViewAt(int paramInt)
  {
    this.mContainer.removeViewAt(paramInt);
  }
  
  public void setArrowVisiale(boolean paramBoolean)
  {
    ImageView localImageView = this.gX;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemView
 * JD-Core Version:    0.7.0.1
 */