package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arfr;
import arft;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.Switch;

public class FormCommonSwitchItem
  extends RelativeLayout
  implements arft
{
  private int mBgType;
  private boolean mChecked;
  private CharSequence mContentDesc;
  private int mItemHeight;
  private int mPadding = getResources().getDimensionPixelSize(2131299617);
  private CharSequence mText;
  private TextView mTextView;
  private Switch u;
  
  public FormCommonSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131299616);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qB);
    this.mItemHeight = paramContext.getDimensionPixelSize(1, i);
    this.mText = paramContext.getString(23);
    this.mChecked = paramContext.getBoolean(21, false);
    this.mBgType = paramContext.getInt(0, 0);
    paramContext.recycle();
    initViews();
  }
  
  public static Drawable e(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839690);
    case 0: 
      return paramResources.getDrawable(2130839693);
    case 1: 
      return paramResources.getDrawable(2130839690);
    case 2: 
      return paramResources.getDrawable(2130839690);
    case 3: 
      return paramResources.getDrawable(2130839693);
    case 4: 
      return paramResources.getDrawable(2130839693);
    }
    return null;
  }
  
  @TargetApi(16)
  private void initViews()
  {
    this.mTextView = new TextView(getContext());
    this.mTextView.setId(2131367519);
    if (!TextUtils.isEmpty(this.mText)) {
      this.mTextView.setText(this.mText);
    }
    this.mTextView.setSingleLine(true);
    this.mTextView.setTextSize(2, 18.0F);
    this.mTextView.setTextColor(getResources().getColor(2131167304));
    this.mTextView.setGravity(19);
    this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.mPadding;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.mPadding;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131367518);
    addView(this.mTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new View(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.mPadding);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(0, 2131367518);
    addView((View)localObject, localLayoutParams);
    this.u = new Switch(getContext());
    this.u.setChecked(this.mChecked);
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 16))
    {
      this.u.setAccessibilityDelegate(new arfr(this));
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.mTextView.getText());
      }
    }
    this.u.setId(2131367518);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.mPadding;
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.u, (ViewGroup.LayoutParams)localObject);
    setBackgroundDrawable(e(getResources(), this.mBgType));
  }
  
  String CQ()
  {
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(this.mContentDesc);
    if ((this.u != null) && (this.u.getVisibility() != 8))
    {
      if (!this.u.isChecked()) {
        break label67;
      }
      localStringBuilder.append(getContext().getString(2131692132));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label67:
      localStringBuilder.append(getContext().getString(2131692134));
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.mContentDesc != null) && (!this.mContentDesc.equals(paramAccessibilityNodeInfo.getContentDescription()))) {
      paramAccessibilityNodeInfo.setContentDescription(CQ());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.enableTalkBack) && (this.u != null) && (this.u.getVisibility() == 0))
    {
      if (paramMotionEvent.getAction() == 0) {
        super.onTouchEvent(paramMotionEvent);
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      paramMotionEvent = this.u;
      if (!this.u.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMotionEvent.setChecked(bool);
        this.u.sendAccessibilityEvent(1);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.mBgType = paramInt;
    setBackgroundDrawable(e(getResources(), this.mBgType));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.u != null) {
      this.u.setChecked(paramBoolean);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.mContentDesc = paramCharSequence;
    super.setContentDescription(CQ());
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.u != null) {
      this.u.setEnabled(paramBoolean);
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.u != null) {
      this.u.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.mTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.mText = paramCharSequence;
        this.mTextView.setText(this.mText);
        this.mTextView.setTextColor(getResources().getColor(2131167304));
        this.mTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormCommonSwitchItem
 * JD-Core Version:    0.7.0.1
 */