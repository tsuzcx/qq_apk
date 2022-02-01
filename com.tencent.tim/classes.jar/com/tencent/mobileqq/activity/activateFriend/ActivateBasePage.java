package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class ActivateBasePage
  extends RelativeLayout
{
  public static float pr = 2.364865F;
  TextView Ho;
  TextView Hp;
  TextView Hq;
  TextView Hr;
  public ActivateFriendGrid a;
  public Button dM;
  TextView iG;
  LayoutInflater mInflater;
  View mRootView = null;
  
  public ActivateBasePage(Context paramContext)
  {
    super(paramContext);
    this.mInflater = LayoutInflater.from(paramContext);
    initUI();
    if (this.a != null) {
      this.a.setTextScrolling(false);
    }
  }
  
  public ActivateBasePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  protected void KR() {}
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  protected void eQ(View paramView)
  {
    int i = (int)((int)(getResources().getDisplayMetrics().widthPixels - 16.0F * getResources().getDisplayMetrics().density) / pr);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = i;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public abstract void initUI();
  
  public void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
 * JD-Core Version:    0.7.0.1
 */