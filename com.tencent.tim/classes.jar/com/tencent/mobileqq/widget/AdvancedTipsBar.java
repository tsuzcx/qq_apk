package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import auvj;
import com.tencent.common.app.BaseApplicationImpl;
import rpq;

public class AdvancedTipsBar
  extends TipsBar
{
  public AdvancedTipsBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdvancedTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void TB(boolean paramBoolean)
  {
    super.TB(paramBoolean);
    ehJ();
  }
  
  public void ehG()
  {
    if (!auvj.isNightMode()) {}
    for (int i = Color.parseColor("#03081A");; i = Color.parseColor("#FFFFFF"))
    {
      this.mTextView.setTextColor(i);
      return;
    }
  }
  
  public void ehH() {}
  
  protected void ehI()
  {
    super.ehI();
    if (this.ir != null)
    {
      this.ir.setId(2131379762);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ir.getLayoutParams();
      localLayoutParams.rightMargin = rpq.dip2px(BaseApplicationImpl.context, 16.0F);
      this.ir.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void ehJ()
  {
    super.ehJ();
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.mButton != null)
    {
      this.mButton.setId(2131379761);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mButton.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = rpq.dip2px(BaseApplicationImpl.context, 44.0F);
      if (auvj.isNightMode()) {
        break label110;
      }
    }
    label110:
    for (int i = Color.parseColor("#4D94FF");; i = Color.parseColor("#0071FF"))
    {
      this.mButton.setTextColor(i);
      this.mButton.setLayoutParams(localLayoutParams);
      if (this.mTextView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
        localLayoutParams.addRule(0, 2131379761);
        this.mTextView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdvancedTipsBar
 * JD-Core Version:    0.7.0.1
 */