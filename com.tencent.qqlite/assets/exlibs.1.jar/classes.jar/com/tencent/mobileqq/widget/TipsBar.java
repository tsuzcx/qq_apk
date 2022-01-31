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
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlite.R.styleable;

public class TipsBar
  extends RelativeLayout
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  private float jdField_a_of_type_Float;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.jdField_a_of_type_Float = localResources.getDisplayMetrics().density;
    this.e = localResources.getDimensionPixelSize(2131493091);
    this.f = localResources.getDimensionPixelSize(2131493092);
    this.g = localResources.getDimensionPixelSize(2131493093);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.x);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2);
    this.b = paramContext.getString(5);
    this.d = paramContext.getInt(0, 2);
    this.h = paramContext.getDimensionPixelSize(3, 0);
    this.i = paramContext.getDimensionPixelSize(4, 0);
    paramContext.recycle();
    a();
  }
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131427481);
    case 1: 
      return paramResources.getColorStateList(2131427481);
    case 2: 
      return paramResources.getColorStateList(2131427486);
    }
    return paramResources.getColorStateList(2131427481);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130837743);
    case 1: 
      return paramResources.getDrawable(2130837749);
    case 2: 
      return paramResources.getDrawable(2130837749);
    }
    return paramResources.getDrawable(2130837743);
  }
  
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296403);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.d));
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    setTipsIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.h, this.i);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.f;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296404);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    if (!TextUtils.isEmpty(this.b)) {
      b();
    }
    for (;;)
    {
      setBackgroundDrawable(b(localResources, this.d));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296404);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      localObject = c(localResources, this.d);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = this.f;
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public static ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131427472);
    case 1: 
      return paramResources.getColorStateList(2131427469);
    case 2: 
      return paramResources.getColorStateList(2131427472);
    }
    return paramResources.getColorStateList(2131427472);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130837949);
    case 1: 
      return paramResources.getDrawable(2130837950);
    case 2: 
      return paramResources.getDrawable(2130837949);
    }
    return paramResources.getDrawable(2130837948);
  }
  
  private void b()
  {
    Object localObject = getResources();
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131296404);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.b);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.b);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(2, 15.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(a((Resources)localObject, this.d));
    this.jdField_a_of_type_AndroidWidgetButton.setMinWidth((int)(this.jdField_a_of_type_Float * 56.0F + 0.5D));
    this.jdField_a_of_type_AndroidWidgetButton.setMinHeight((int)(this.jdField_a_of_type_Float * 30.0F + 0.5D));
    this.jdField_a_of_type_AndroidWidgetButton.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a((Resources)localObject, this.d));
    int j = (int)(this.jdField_a_of_type_Float * 11.0F + 0.5D);
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(j, 0, j, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.f;
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
  }
  
  public static Drawable c(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130837947);
    case 1: 
      return paramResources.getDrawable(2130837947);
    case 2: 
      return paramResources.getDrawable(2130837946);
    }
    return paramResources.getDrawable(2130837946);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.e);
  }
  
  public void setBarType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    if (paramInt == this.d) {}
    Resources localResources;
    do
    {
      return;
      this.d = paramInt;
      localResources = getResources();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.d));
      }
      setBackgroundDrawable(b(localResources, this.d));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        Drawable localDrawable = c(localResources, this.d);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    } while (this.jdField_a_of_type_AndroidWidgetButton == null);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(a(localResources, this.d));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(localResources, this.d));
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.b = paramCharSequence.toString();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        b();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramCharSequence);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    super.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void setTipsIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable.getIntrinsicHeight() > this.e)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.e);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.g);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setTipsIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.h = paramInt1;
        this.i = Math.min(this.e, paramInt2);
        paramDrawable.setBounds(0, 0, this.h, this.i);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.g);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setTipsIcon(paramDrawable);
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TipsBar
 * JD-Core Version:    0.7.0.1
 */