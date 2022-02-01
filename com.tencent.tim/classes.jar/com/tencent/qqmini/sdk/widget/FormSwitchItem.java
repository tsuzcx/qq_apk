package com.tencent.qqmini.sdk.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.color;
import com.tencent.qqmini.sdk.R.dimen;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.styleable;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ViewUtils;

public class FormSwitchItem
  extends RelativeLayout
{
  public static final int BG_TYPE_BOTTOM = 3;
  public static final int BG_TYPE_MIDDLE = 2;
  public static final int BG_TYPE_SINGLE = 0;
  public static final int BG_TYPE_TOP = 1;
  int COLOR_DEFAULT_BG_DIVIDER = Color.parseColor("#EBEDF5");
  int HEIGHT_DEFAULT_BG_DIVIDER = ViewUtils.dpToPx(0.5F);
  int PADDING_DEFAULT_BG_DIVIDER = ViewUtils.dpToPx(16.0F);
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
  protected Switch mSwitch;
  private CharSequence mText;
  private TextView mTextView;
  
  public FormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_item_padding_p0);
    int j = getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_single_line_height);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MiniSdkFormItem);
    this.mPadding = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_customPaddingSdk, i);
    this.mItemHeight = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_customHeightSdk, j);
    this.mText = paramContext.getString(R.styleable.MiniSdkFormItem_switchTextSdk);
    this.mLeftIcon = paramContext.getDrawable(R.styleable.MiniSdkFormItem_leftIconSdk);
    this.mLeftIconWidth = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_leftIconWidthSdk, 0);
    this.mLeftIconHeight = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_leftIconHeightSdk, 0);
    this.mLeftIconHeight = Math.min(this.mItemHeight, this.mLeftIconHeight);
    this.mRightIcon = paramContext.getDrawable(R.styleable.MiniSdkFormItem_rightIconSdk);
    this.mRightIconWidth = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_rightIconWidthSdk, 0);
    this.mRightIconHeight = paramContext.getDimensionPixelSize(R.styleable.MiniSdkFormItem_rightIconHeightSdk, 0);
    this.mRightIconHeight = Math.min(this.mItemHeight, this.mRightIconHeight);
    this.mChecked = paramContext.getBoolean(R.styleable.MiniSdkFormItem_switchCheckedSdk, false);
    this.mBgType = paramContext.getInt(R.styleable.MiniSdkFormItem_bgTypeSdk, 0);
    paramContext.recycle();
    this.mNeedSetHeight = true;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.COLOR_DEFAULT_BG_DIVIDER);
    initViews();
  }
  
  public static Drawable getBgDrawable(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return paramResources.getDrawable(R.drawable.mini_sdk_skin_setting_strip_bg_unpressed);
  }
  
  private void initViews()
  {
    this.mTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.mText)) {
      this.mTextView.setText(this.mText);
    }
    this.mTextView.setSingleLine(true);
    int i = getContext().getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_prime_textsize);
    this.mTextView.setTextSize(0, i);
    this.mTextView.setTextColor(getResources().getColorStateList(R.color.mini_sdk_skin_black));
    this.mTextView.setGravity(19);
    this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
    setRightIcon(this.mRightIcon, this.mRightIconWidth, this.mRightIconHeight);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.mPadding;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.mTextView, localLayoutParams);
    this.mSwitch = new Switch(getContext());
    this.mSwitch.setChecked(this.mChecked);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.mPadding;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.mSwitch, localLayoutParams);
    setBackgroundDrawable(getBgDrawable(getResources(), this.mBgType, isDefTheme()));
  }
  
  private boolean isDefTheme()
  {
    return true;
  }
  
  public Switch getSwitch()
  {
    return this.mSwitch;
  }
  
  public boolean isChecked()
  {
    if (this.mSwitch != null) {
      return this.mSwitch.isChecked();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mBgType == 1) || (this.mBgType == 2))
    {
      if (!isDefTheme()) {
        break label76;
      }
      this.mPaint.setColor(this.COLOR_DEFAULT_BG_DIVIDER);
    }
    for (;;)
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.mRect.set(this.PADDING_DEFAULT_BG_DIVIDER, j - this.HEIGHT_DEFAULT_BG_DIVIDER, i, j);
      paramCanvas.drawRect(this.mRect, this.mPaint);
      return;
      label76:
      this.mPaint.setColor(0);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.mSwitch != null) && (this.mSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.mSwitch.isChecked());
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
        if (QMLog.isColorLevel()) {
          QMLog.d("FormSwitchItem", localException.toString());
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
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.mSwitch != null)
    {
      this.mSwitch.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    if (this.mTextView != null) {
      this.mTextView.setEnabled(paramBoolean);
    }
    if (this.mSwitch != null) {
      this.mSwitch.setEnabled(paramBoolean);
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
    if (this.mSwitch != null) {
      this.mSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
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
        this.mTextView.setTextColor(getResources().getColorStateList(R.color.mini_sdk_skin_black));
      }
    }
    else {
      return;
    }
    this.mTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */