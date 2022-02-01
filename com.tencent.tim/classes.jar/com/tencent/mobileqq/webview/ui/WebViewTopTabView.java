package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import aqcx;
import java.util.Arrays;

public class WebViewTopTabView
  extends RadioGroup
{
  LayoutInflater mInflater;
  public int[] pg;
  RadioButton u;
  RadioButton v;
  
  public WebViewTopTabView(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public int[] ai()
  {
    int k = super.getChildCount();
    if (k > 0)
    {
      int[] arrayOfInt = new int[k];
      Arrays.fill(arrayOfInt, -1);
      int i = 0;
      if (i < k)
      {
        if (((WebViewTopTabRadioButton)super.getChildAt(i)).cYV) {}
        for (int j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
      return arrayOfInt;
    }
    return null;
  }
  
  RadioButton b(int paramInt)
  {
    Object localObject;
    if (this.mInflater != null) {
      localObject = (RadioButton)this.mInflater.inflate(2131563343, this, false);
    }
    for (;;)
    {
      ((RadioButton)localObject).setId(paramInt);
      return localObject;
      localObject = new WebViewTopTabRadioButton(super.getContext(), null);
      ((RadioButton)localObject).setButtonDrawable(super.getContext().getResources().getDrawable(17170445));
      ((RadioButton)localObject).setTextSize(14.0F);
      ((RadioButton)localObject).setGravity(17);
    }
  }
  
  public void setButtonBackgroundResource(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.u != null) {
      this.u.setBackgroundResource(paramInt1);
    }
    paramInt1 = 1;
    while (paramInt1 < super.getChildCount() - 1)
    {
      super.getChildAt(paramInt1).setBackgroundResource(paramInt2);
      paramInt1 += 1;
    }
    if (this.v != null) {
      this.v.setBackgroundResource(paramInt3);
    }
  }
  
  public void setButtonNum(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 2) {
      i = 2;
    }
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < i) {}
    }
    else
    {
      paramInt1 = 0;
    }
    this.pg = new int[i];
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.pg[paramInt2] = paramInt2;
      paramInt2 += 1;
    }
    super.removeAllViews();
    this.u = b(this.pg[0]);
    Object localObject;
    if (this.u.getLayoutParams() == null)
    {
      localObject = new LinearLayout.LayoutParams(-2, aqcx.dip2px(super.getContext(), 30.0F));
      super.addView(this.u, (ViewGroup.LayoutParams)localObject);
      paramInt2 = 1;
      label110:
      if (paramInt2 >= i - 1) {
        break label188;
      }
      localObject = b(this.pg[paramInt2]);
      if (((RadioButton)localObject).getLayoutParams() != null) {
        break label179;
      }
      super.addView((View)localObject, new LinearLayout.LayoutParams(-2, aqcx.dip2px(super.getContext(), 30.0F)));
    }
    for (;;)
    {
      paramInt2 += 1;
      break label110;
      super.addView(this.u);
      break;
      label179:
      super.addView((View)localObject);
    }
    label188:
    this.v = b(this.pg[(i - 1)]);
    if (this.v == null)
    {
      localObject = new LinearLayout.LayoutParams(-2, aqcx.dip2px(super.getContext(), 30.0F));
      super.addView(this.v, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      super.setGravity(16);
      ((RadioButton)super.getChildAt(paramInt1)).setChecked(true);
      return;
      super.addView(this.v);
    }
  }
  
  public void setButtonText(String... paramVarArgs)
  {
    if ((super.getChildCount() > 0) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int i = 0;
      while (i < super.getChildCount())
      {
        RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
        if (i >= paramVarArgs.length) {
          break;
        }
        localRadioButton.setText(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public void setButtonTextColorStateList(int paramInt)
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      ((RadioButton)super.getChildAt(i)).setTextColor(super.getContext().getResources().getColorStateList(paramInt));
      i += 1;
    }
  }
  
  public void setLeftAndRightPaddingByDp(int paramInt)
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      super.getChildAt(i).setPadding(aqcx.dip2px(super.getContext(), paramInt), super.getPaddingTop(), aqcx.dip2px(super.getContext(), paramInt), super.getPaddingBottom());
      i += 1;
    }
  }
  
  public void setRedHotStatus(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if ((k >= 0) && (k < super.getChildCount()))
        {
          WebViewTopTabRadioButton localWebViewTopTabRadioButton = (WebViewTopTabRadioButton)super.getChildAt(k);
          if (localWebViewTopTabRadioButton.cYV != paramBoolean)
          {
            localWebViewTopTabRadioButton.cYV = paramBoolean;
            localWebViewTopTabRadioButton.invalidate();
          }
        }
        i += 1;
      }
    }
  }
  
  public void setSelectedTab(int paramInt)
  {
    if (super.getChildCount() > 0)
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < super.getChildCount()) {}
      }
      else
      {
        i = 0;
      }
      ((RadioButton)super.getChildAt(i)).setChecked(true);
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (super.getChildCount() > 0)
    {
      int i = 0;
      while (i < super.getChildCount())
      {
        ((RadioButton)super.getChildAt(i)).setTextSize(paramFloat);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabView
 * JD-Core Version:    0.7.0.1
 */