package com.tencent.mobileqq.widget;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PadQQCheckBox
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView Fz;
  private CharSequence aG;
  private boolean isChecked;
  private TextView mCheckText;
  
  public PadQQCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public PadQQCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ri);
    this.isChecked = paramAttributeSet.getBoolean(0, true);
    this.aG = paramAttributeSet.getString(1);
    LayoutInflater.from(paramContext).inflate(2131559732, this, true);
    this.Fz = ((ImageView)findViewById(2131364578));
    this.mCheckText = ((TextView)findViewById(2131364586));
    setChecked(this.isChecked);
    this.mCheckText.setText(this.aG);
    paramAttributeSet.recycle();
    setOnClickListener(this);
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void onClick(View paramView)
  {
    if (!this.isChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (this.isChecked) {}
    for (String str = acfp.m(2131709390);; str = acfp.m(2131709389))
    {
      paramAccessibilityNodeInfo.setContentDescription(this.aG + str);
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
    if (this.isChecked) {
      this.Fz.setImageResource(2130851276);
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      this.Fz.setImageResource(2130851277);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if ((this.mCheckText != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.aG = paramCharSequence;
      this.mCheckText.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PadQQCheckBox
 * JD-Core Version:    0.7.0.1
 */