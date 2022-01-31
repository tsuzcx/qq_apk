package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlite.R.styleable;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements FormItemConstants
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private int i;
  private int j;
  private int k = getResources().getDimensionPixelSize(2131493070);
  private int l;
  private int m;
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int n = getResources().getDimensionPixelSize(2131493069);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.e);
    this.j = paramContext.getDimensionPixelSize(3, n);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(13);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.l = paramContext.getDimensionPixelSize(1, 0);
    this.m = paramContext.getDimensionPixelSize(2, 0);
    this.m = Math.min(this.j, this.m);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(14, false);
    this.i = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return paramResources.getDrawable(2130837914);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296405);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427469));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.l, this.m);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.k;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, 2131296406);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setId(2131296406);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.k;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.i));
  }
  
  public Switch a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwitch;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentWidgetSwitch == null) || (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() == 0))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, getResources()), AIOUtils.a(24.0F, getResources()));
      localLayoutParams.rightMargin = this.k;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837921));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked();
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.j);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.i = paramInt;
    setBackgroundDrawable(a(getResources(), this.i));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(paramCharSequence);
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.j = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.j)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.j);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.k);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.l = paramInt1;
        this.m = Math.min(this.j, paramInt2);
        paramDrawable.setBounds(0, 0, this.l, this.m);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.k);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427469));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */