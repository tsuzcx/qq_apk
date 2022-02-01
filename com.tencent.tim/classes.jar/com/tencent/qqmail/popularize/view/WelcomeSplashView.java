package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class WelcomeSplashView
  extends RelativeLayout
{
  private View mCenterView;
  private int mCenterViewBottomRatio;
  
  public WelcomeSplashView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WelcomeSplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WelcomeSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mCenterView != null) && (this.mCenterView.getParent() == this) && (this.mCenterView.getVisibility() == 0))
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt3 = this.mCenterViewBottomRatio * paramInt2 / 100;
      paramInt1 = this.mCenterView.getHeight();
      paramInt2 = Math.min(Math.max(paramInt2 - paramInt3, paramInt1), paramInt2);
      this.mCenterView.layout(this.mCenterView.getLeft(), paramInt2 - paramInt1, this.mCenterView.getRight(), paramInt2);
    }
  }
  
  public void setCenterViewBottomRatio(View paramView, int paramInt)
  {
    this.mCenterView = paramView;
    this.mCenterViewBottomRatio = Math.max(Math.min(paramInt, 100), 0);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.WelcomeSplashView
 * JD-Core Version:    0.7.0.1
 */