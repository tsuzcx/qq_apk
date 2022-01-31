package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqqi.R.styleable;
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
  private int h;
  private int i;
  private int j = getResources().getDimensionPixelSize(2131427602);
  private int k;
  private int l;
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int m = getResources().getDimensionPixelSize(2131427601);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.A);
    this.i = paramContext.getDimensionPixelSize(3, m);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(13);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.k = paramContext.getDimensionPixelSize(1, 0);
    this.l = paramContext.getDimensionPixelSize(2, 0);
    this.l = Math.min(this.i, this.l);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(14, false);
    this.h = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130840178);
    case 0: 
      return paramResources.getDrawable(2130840178);
    case 1: 
      return paramResources.getDrawable(2130840188);
    case 2: 
      return paramResources.getDrawable(2130840186);
    }
    return paramResources.getDrawable(2130840180);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131362080));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.k, this.l);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.j;
    localLayoutParams.rightMargin = (this.j * 3);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setBackgroundResource(2130837829);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.j;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.h));
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
      localLayoutParams.rightMargin = this.j;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837853));
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
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.i * 3, -2147483648));
    setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.h = paramInt;
    setBackgroundDrawable(a(getResources(), this.h));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {}
    for (String str = "关";; str = "开")
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(paramCharSequence + str);
      return;
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.i = paramInt;
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
    if (paramDrawable.getIntrinsicHeight() > this.i)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.i);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.j);
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
        this.k = paramInt1;
        this.l = Math.min(this.i, paramInt2);
        paramDrawable.setBounds(0, 0, this.k, this.l);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.j);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131362080));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */