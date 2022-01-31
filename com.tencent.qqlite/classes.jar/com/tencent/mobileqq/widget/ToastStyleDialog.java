package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class ToastStyleDialog
  extends Dialog
{
  private static final int jdField_a_of_type_Int = 10;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ToastStyleDialog(Context paramContext)
  {
    super(paramContext, 2131624092);
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    setContentView(2130903548);
    this.a = ((TextView)findViewById(2131297375));
    setCancelable(false);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ToastStyleDialog
 * JD-Core Version:    0.7.0.1
 */