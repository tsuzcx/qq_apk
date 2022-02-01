package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ADViewIndividuation
  extends ADView
{
  private int eeO;
  
  public ADViewIndividuation(Context paramContext)
  {
    super(paramContext);
    this.eeM = 8;
    this.eeN = 18;
    this.bwo = 2130847900;
    this.bwp = this.bwo;
  }
  
  public ADViewIndividuation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.eeM = 4;
    this.eeN = 8;
    this.bwo = 2130847900;
    this.bwp = this.bwo;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(7, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.density));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setPadding((int)(4.0F * this.density), 0, (int)(2.0F * this.density), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void av(View paramView, int paramInt)
  {
    super.av(paramView, paramInt);
    setNavVisible(this.eeO, false);
  }
  
  public void setNavVisible(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      Object localObject = (ViewGroup)this.linearLayout.getChildAt(0);
      if (localObject != null)
      {
        localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
        if (localObject != null)
        {
          if (paramInt > 0) {}
          for (paramInt = 0;; paramInt = 8)
          {
            ((LinearLayout)localObject).setVisibility(paramInt);
            if (!paramBoolean) {
              break;
            }
            this.eeO = 0;
            return;
          }
        }
      }
    } while (!paramBoolean);
    this.eeO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADViewIndividuation
 * JD-Core Version:    0.7.0.1
 */