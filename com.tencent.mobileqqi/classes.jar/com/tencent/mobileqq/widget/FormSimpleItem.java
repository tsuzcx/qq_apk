package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqqi.R.styleable;

public class FormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = getResources().getDimensionPixelSize(2131427599);
  private int q;
  private int r;
  private int s;
  private int t;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131427598);
    this.q = ((int)(getResources().getDisplayMetrics().density * 175.0F + 0.5D));
    this.r = ((int)(getResources().getDisplayMetrics().density * 35.0F + 0.5D));
    this.s = ((int)(getResources().getDisplayMetrics().density * 15.0F + 0.5D));
    this.t = ((int)(getResources().getDisplayMetrics().density * 260.0F + 0.5D));
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837803);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.A);
    this.o = paramContext.getDimensionPixelSize(3, i1);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(4);
    this.j = paramContext.getInt(6, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.h = paramContext.getDimensionPixelSize(1, 0);
    this.i = paramContext.getDimensionPixelSize(2, 0);
    this.i = Math.min(this.o, this.i);
    this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(7);
    this.m = paramContext.getInt(11, 2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(8);
    this.k = paramContext.getDimensionPixelSize(9, 0);
    this.l = paramContext.getDimensionPixelSize(10, 0);
    this.l = Math.min(this.o, this.l);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(12, false);
    this.n = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131362070);
    case 0: 
      return paramResources.getColorStateList(2131362070);
    case 2: 
      return paramResources.getColorStateList(2131362099);
    }
    return paramResources.getColorStateList(2131362073);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130837875);
    case 0: 
      return paramResources.getDrawable(2130837875);
    case 1: 
      return paramResources.getDrawable(2130837880);
    case 2: 
      return paramResources.getDrawable(2130837879);
    }
    return paramResources.getDrawable(2130837877);
  }
  
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.h, this.i);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.p;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.t);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(80);
    this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_c_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.p;
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131427600);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131427601);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    b();
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
        {
          if ((this.k > 0) && (this.l > 0))
          {
            if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
              this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
            }
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.r + this.p + this.q + this.p + this.s);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.k > 0) && (this.l > 0))
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.r + this.p + this.q);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
          this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.q + this.p + this.s);
          return;
        }
      } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.q);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p / 2);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.o);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.n = paramInt;
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  public void setBottomText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramCharSequence);
      setCustomHeight(getResources().getDimensionPixelSize(2131427602));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.o = paramInt;
      requestLayout();
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
    if (paramDrawable.getIntrinsicHeight() > this.o)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.o);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
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
        this.h = paramInt1;
        this.i = Math.min(this.o, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.i);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.j = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    this.k = paramInt1;
    this.l = Math.min(this.o, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    b();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    b();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.m = paramInt;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */