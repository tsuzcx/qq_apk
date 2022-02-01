package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import aqnm;
import atau.a;
import com.tencent.common.config.AppSetting;

public class FormMultiLineSwitchItem
  extends FormSwitchItem
{
  TextView abU;
  TextView abV;
  String cAn;
  
  public FormMultiLineSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mNeedSetHeight = false;
    this.cAn = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qB).getString(22);
    initViews();
  }
  
  private void initViews()
  {
    this.abU = getTextView();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.abU.getLayoutParams();
    localLayoutParams.addRule(15, 0);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296919);
    this.abU.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.abV = new TextView(getContext());
    if (!TextUtils.isEmpty(this.cAn)) {
      this.abV.setText(this.cAn);
    }
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 16))
    {
      aqcl.Q(this.abV, false);
      setContentDescription(this.abU.getText() + " " + this.cAn);
    }
    this.abV.setSingleLine(false);
    this.abV.setDuplicateParentStateEnabled(true);
    int i = aqnm.getScreenWidth();
    int j = aqnm.dip2px(96.0F);
    this.abV.setMaxWidth(i - j);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296909);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131296915);
    localLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131298645);
    localLayoutParams.addRule(3, 2131367519);
    i = getResources().getDimensionPixelSize(2131296934);
    this.abV.setTextColor(getResources().getColorStateList(2131167379));
    this.abV.setTextSize(0, i);
    this.abV.setGravity(19);
    addView(this.abV, localLayoutParams);
  }
  
  public void setSecendLineText(String paramString)
  {
    this.abV.setText(paramString);
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 16)) {
      setContentDescription(this.abU.getText() + " " + this.cAn);
    }
  }
  
  public void setSecondLineTextViewVisibility(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.abV != null)
    {
      this.abV.setVisibility(paramInt);
      localLayoutParams = (RelativeLayout.LayoutParams)this.abU.getLayoutParams();
      if (paramInt == 8)
      {
        setMinimumHeight(getResources().getDimensionPixelSize(2131296927));
        localLayoutParams.addRule(15, -1);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(15, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMultiLineSwitchItem
 * JD-Core Version:    0.7.0.1
 */