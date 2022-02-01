package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import arft;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements arft
{
  private int mBgType;
  private boolean mChecked;
  private int mItemHeight;
  private Drawable mLeftIcon;
  private int mLeftIconHeight;
  private int mLeftIconWidth;
  protected boolean mNeedSetHeight;
  private int mPadding;
  private final Paint mPaint = new Paint();
  private final Rect mRect = new Rect();
  private Drawable mRightIcon;
  private int mRightIconHeight;
  private int mRightIconWidth;
  private CharSequence mText;
  private TextView mTextView;
  protected Switch u;
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131298645);
    int j = getResources().getDimensionPixelSize(2131296927);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qB);
    this.mPadding = paramContext.getDimensionPixelSize(2, i);
    this.mItemHeight = paramContext.getDimensionPixelSize(1, j);
    this.mText = paramContext.getString(23);
    this.mLeftIcon = paramContext.getDrawable(6);
    this.mLeftIconWidth = paramContext.getDimensionPixelSize(8, 0);
    this.mLeftIconHeight = paramContext.getDimensionPixelSize(7, 0);
    this.mLeftIconHeight = Math.min(this.mItemHeight, this.mLeftIconHeight);
    this.mRightIcon = paramContext.getDrawable(14);
    this.mRightIconWidth = paramContext.getDimensionPixelSize(16, 0);
    this.mRightIconHeight = paramContext.getDimensionPixelSize(15, 0);
    this.mRightIconHeight = Math.min(this.mItemHeight, this.mRightIconHeight);
    this.mChecked = paramContext.getBoolean(21, false);
    this.mBgType = paramContext.getInt(0, 0);
    paramContext.recycle();
    this.mNeedSetHeight = true;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(COLOR_DEFAULT_BG_DIVIDER);
    initViews();
  }
  
  public static Drawable getBgDrawable(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramResources.getDrawable(2130851351);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130851351);
    case 0: 
      return paramResources.getDrawable(2130851351);
    case 1: 
      return paramResources.getDrawable(2130851371);
    case 2: 
      return paramResources.getDrawable(2130851365);
    case 3: 
      return paramResources.getDrawable(2130851356);
    case 4: 
      return paramResources.getDrawable(2130839693);
    }
    return null;
  }
  
  private void initViews()
  {
    this.mTextView = new TextView(getContext());
    this.mTextView.setId(2131367519);
    if (!TextUtils.isEmpty(this.mText)) {
      this.mTextView.setText(this.mText);
    }
    this.mTextView.setSingleLine(true);
    int i = getContext().getResources().getDimensionPixelSize(2131296925);
    this.mTextView.setTextSize(0, i);
    this.mTextView.setTextColor(getResources().getColorStateList(2131167304));
    this.mTextView.setGravity(19);
    this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
    setRightIcon(this.mRightIcon, this.mRightIconWidth, this.mRightIconHeight);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.mPadding;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.mTextView, localLayoutParams);
    this.u = new Switch(getContext());
    this.u.setChecked(this.mChecked);
    if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 16))
    {
      aqcl.Q(this.mTextView, false);
      aqcl.Q(this.u, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.mTextView.getText());
      }
    }
    this.u.setId(2131367518);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.mPadding;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.u, localLayoutParams);
    setBackgroundDrawable(getBgDrawable(getResources(), this.mBgType, isDefTheme()));
  }
  
  private boolean isDefTheme()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public Switch a()
  {
    return this.u;
  }
  
  public TextView getTextView()
  {
    return this.mTextView;
  }
  
  public boolean isChecked()
  {
    if (this.u != null) {
      return this.u.isChecked();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mBgType == 1) || (this.mBgType == 2))
    {
      if (!isDefTheme()) {
        break label73;
      }
      this.mPaint.setColor(COLOR_DEFAULT_BG_DIVIDER);
    }
    for (;;)
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.mRect.set(PADDING_DEFAULT_BG_DIVIDER, j - HEIGHT_DEFAULT_BG_DIVIDER, i, j);
      paramCanvas.drawRect(this.mRect, this.mPaint);
      return;
      label73:
      this.mPaint.setColor(0);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.u != null) && (this.u.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.u.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mNeedSetHeight) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FormSwitchItem", 2, localException.toString());
        }
        setMinimumHeight(this.mItemHeight);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
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
    setBackgroundDrawable(getBgDrawable(getResources(), this.mBgType, isDefTheme()));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.u != null)
    {
      this.u.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mItemHeight = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    if (this.mTextView != null) {
      this.mTextView.setEnabled(paramBoolean);
    }
    if (this.u != null) {
      this.u.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.mTextView != null)
    {
      this.mLeftIcon = paramDrawable;
      if (paramDrawable == null) {
        this.mTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.mItemHeight)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.mItemHeight);
      this.mTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.mTextView.setCompoundDrawablePadding(this.mPadding);
      return;
      this.mTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.mTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.mLeftIcon = paramDrawable;
        this.mLeftIconWidth = paramInt1;
        this.mLeftIconHeight = Math.min(this.mItemHeight, paramInt2);
        paramDrawable.setBounds(0, 0, this.mLeftIconWidth, this.mLeftIconHeight);
        this.mTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.mTextView.setCompoundDrawablePadding(this.mPadding);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setRightIcon(paramDrawable);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.u != null) {
      this.u.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    if (this.mTextView != null)
    {
      this.mRightIcon = paramDrawable;
      if (paramDrawable == null) {
        this.mTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.mItemHeight)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.mItemHeight);
      this.mTextView.setCompoundDrawables(null, null, paramDrawable, null);
    }
    for (;;)
    {
      this.mTextView.setCompoundDrawablePadding(this.mPadding);
      return;
      this.mTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.mTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.mRightIcon = paramDrawable;
        this.mRightIconWidth = paramInt1;
        this.mRightIconHeight = Math.min(this.mItemHeight, paramInt2);
        paramDrawable.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
        this.mTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.mTextView.setCompoundDrawablePadding(this.mPadding);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setRightIcon(paramDrawable);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.mTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.mText = paramCharSequence;
        this.mTextView.setText(this.mText);
        this.mTextView.setTextColor(getResources().getColorStateList(2131167304));
      }
    }
    else {
      return;
    }
    this.mTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */