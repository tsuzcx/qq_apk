package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import euf;
import eug;
import euh;
import eui;
import euj;
import euk;
import eul;

public class QQCustomDialogThreeBtns
  extends Dialog
{
  public DialogInterface.OnClickListener a;
  public LayoutInflater a;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new euf(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String[] a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public QQCustomDialogThreeBtns(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomDialogThreeBtns(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomDialogThreeBtns(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    TextView localTextView = null;
    if (this.d.getVisibility() == 0) {
      localTextView = this.d;
    }
    for (;;)
    {
      if (localTextView != null) {
        localTextView.setTypeface(Typeface.defaultFromStyle(1));
      }
      return;
      if (this.e.getVisibility() == 0) {
        localTextView = this.e;
      } else if (this.c.getVisibility() == 0) {
        localTextView = this.c;
      }
    }
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomDialogThreeBtns a(int paramInt)
  {
    this.b.setText(paramInt);
    this.b.setVisibility(0);
    return this;
  }
  
  public QQCustomDialogThreeBtns a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public QQCustomDialogThreeBtns a(Drawable paramDrawable)
  {
    this.f.setPadding(0, 0, 0, 0);
    this.f.setCompoundDrawablePadding(0);
    this.f.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.f.setVisibility(0);
      return this;
    }
    this.f.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns a(View paramView)
  {
    this.b.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public QQCustomDialogThreeBtns a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns a(String paramString, int paramInt)
  {
    if ((findViewById(paramInt) instanceof TextView))
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    return this;
  }
  
  public QQCustomDialogThreeBtns a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new eug(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns a(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    return this;
  }
  
  public QQCustomDialogThreeBtns b(int paramInt)
  {
    if (this.b != null)
    {
      this.b.setMaxLines(paramInt);
      this.b.setEllipsize(TextUtils.TruncateAt.END);
    }
    return this;
  }
  
  public QQCustomDialogThreeBtns b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new euj(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns b(String paramString)
  {
    if (paramString != null)
    {
      this.b.setText(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new euh(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new euk(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new eui(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns d(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new eul(this, paramOnClickListener));
    a();
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296915));
    this.b = ((TextView)findViewById(2131296470));
    this.f = ((TextView)findViewById(2131296926));
    this.c = ((TextView)findViewById(2131296918));
    this.e = ((TextView)findViewById(2131296931));
    this.d = ((TextView)findViewById(2131296919));
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296831));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296922));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns
 * JD-Core Version:    0.7.0.1
 */