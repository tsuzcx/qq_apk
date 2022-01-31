package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import exe;
import exf;
import exg;
import exh;

public class QQCustomSingleButtonDialog
  extends Dialog
{
  public static final int a = 0;
  public static final int b = 1;
  public DialogInterface.OnClickListener a;
  public LayoutInflater a;
  View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new exe(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String[] a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public QQCustomSingleButtonDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomSingleButtonDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomSingleButtonDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt)
  {
    this.b.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.b.setVisibility(0);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(paramInt1);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getContext().getString(paramInt2));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new exg(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = null;
    try
    {
      String[] arrayOfString = getContext().getResources().getStringArray(paramInt);
      localObject = arrayOfString;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        localNotFoundException.printStackTrace();
      }
    }
    return a(localObject, paramOnClickListener);
  }
  
  public QQCustomSingleButtonDialog a(Drawable paramDrawable)
  {
    this.f.setPadding(0, 0, 0, 0);
    this.f.setCompoundDrawablePadding(0);
    this.f.setCompoundDrawables(null, null, null, paramDrawable);
    if (paramDrawable != null)
    {
      this.f.setVisibility(0);
      return this;
    }
    this.f.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    if (paramDrawable == null) {
      return this;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (paramInt < 2)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        return this;
      }
      if (paramInt == 2)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838050);
        return this;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838051);
      return this;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setCompoundDrawablePadding(0);
    this.e.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.e.setVisibility(0);
      return this;
    }
    this.e.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(paramString, 5, 24));
      this.b.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(new QQText(paramString, 5, 20));
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, int paramInt)
  {
    if ((findViewById(paramInt) instanceof TextView))
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
    }
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(new QQText(paramString, 5, 20));
    this.d.setContentDescription(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new exf(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    return this;
  }
  
  public String a()
  {
    return null;
  }
  
  protected void a() {}
  
  public void a(String paramString)
  {
    this.d.setContentDescription(paramString);
  }
  
  public QQCustomSingleButtonDialog b(int paramInt)
  {
    if (this.b != null)
    {
      this.b.setMaxLines(paramInt);
      this.b.setEllipsize(TextUtils.TruncateAt.END);
    }
    return this;
  }
  
  public QQCustomSingleButtonDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new exh(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog b(Drawable paramDrawable)
  {
    return a(paramDrawable, false, 0);
  }
  
  public QQCustomSingleButtonDialog b(View paramView)
  {
    this.b.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public QQCustomSingleButtonDialog b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setAutoLinkMask(1);
      this.b.setMovementMethod(LinkMovementMethod.getInstance());
      this.b.setText(paramString);
      this.b.setContentDescription(paramString);
      this.b.setLinkTextColor(getContext().getResources().getColor(2131427387));
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramString);
  }
  
  public QQCustomSingleButtonDialog c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(paramString);
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog d(String paramString)
  {
    if (paramString != null)
    {
      this.c.setText(paramString);
      this.c.setContentDescription(paramString);
      this.c.setVisibility(0);
      return this;
    }
    this.c.setVisibility(8);
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296912));
    this.b = ((TextView)findViewById(2131296473));
    this.c = ((TextView)findViewById(2131296926));
    this.f = ((TextView)findViewById(2131296922));
    this.e = ((TextView)findViewById(2131296923));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296925));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296924);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131296915));
    this.d = ((TextView)findViewById(2131296916));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296828));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296919));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog
 * JD-Core Version:    0.7.0.1
 */