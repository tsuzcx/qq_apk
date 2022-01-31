package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import eui;
import euj;

public class QQCustomDialogDevLock
  extends Dialog
{
  public static final int a = 0;
  public static final int b = 1;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  TextView e;
  
  public QQCustomDialogDevLock(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomDialogDevLock(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static QQCustomDialogDevLock a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogDevLock(paramContext, 2131624119);
    paramContext.setContentView(2130903576);
    paramContext.c(paramString1);
    paramContext.a(paramString2);
    paramContext.b(paramString3);
    paramContext.b(paramString5, paramOnClickListener1);
    paramContext.a(paramString4, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public QQCustomDialogDevLock a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setContentDescription(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new eui(this, paramOnClickListener));
    a();
    return this;
  }
  
  public String a()
  {
    return null;
  }
  
  protected void a() {}
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public QQCustomDialogDevLock b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setContentDescription(paramString);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new euj(this, paramOnClickListener));
    a();
    return this;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.c.setText(paramString);
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void d(String paramString)
  {
    this.e.setContentDescription(paramString);
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
  
  public void e(String paramString)
  {
    this.d.setContentDescription(paramString);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297358));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298605));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296847));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298607));
    this.c = ((TextView)findViewById(2131296850));
    this.d = ((TextView)findViewById(2131296914));
    this.e = ((TextView)findViewById(2131296915));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogDevLock
 * JD-Core Version:    0.7.0.1
 */