package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqwl;
import com.tencent.common.app.BaseApplicationImpl;
import wja;

public class LiangHaoView
  extends LinearLayout
{
  private View Je;
  private TextView abH;
  public aqwl c;
  
  public LiangHaoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LiangHaoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LiangHaoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(0);
    this.Je = new View(getContext());
    this.Je.setBackgroundResource(2130848043);
    int i = wja.dp2px(12.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.rightMargin = wja.dp2px(5.0F, getResources());
    localLayoutParams.gravity = 16;
    addView(this.Je, localLayoutParams);
    this.abH = new TextView(getContext());
    this.abH.setTextSize(1, 21.0F);
    this.abH.setTextColor(-8947849);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    addView(this.abH, localLayoutParams);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {}
    for (float f = 0.5F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
  
  public void setUin(aqwl paramaqwl)
  {
    int j = 0;
    if ((paramaqwl == null) || (TextUtils.isEmpty(paramaqwl.uin))) {
      return;
    }
    this.c = paramaqwl;
    SpannableString localSpannableString = new SpannableString(paramaqwl.uin);
    int i;
    if (TextUtils.isEmpty(paramaqwl.cyo)) {
      i = -1;
    }
    for (;;)
    {
      if (j != 0) {
        localSpannableString.setSpan(new ForegroundColorSpan(-31676), i, paramaqwl.cyo.length() + i, 18);
      }
      this.abH.setText(localSpannableString);
      setContentDescription(BaseApplicationImpl.getApplication().getString(2131695269) + " " + paramaqwl.uin);
      return;
      i = paramaqwl.uin.indexOf(paramaqwl.cyo);
      if (i >= 0) {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoView
 * JD-Core Version:    0.7.0.1
 */