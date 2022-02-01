package com.tencent.mobileqq.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;
import hgf;
import java.util.List;

public class CustomAlertDialog
  extends AlertDialog
{
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 10;
  public static final int p = 11;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public Context a;
  ListView jdField_a_of_type_AndroidWidgetListView;
  public CustomAlertDialog.OnOptionMenuClick a;
  public CustomAlertDialog.OnPrepareOptionMenuItem a;
  int b;
  int c;
  int d;
  
  public CustomAlertDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, List paramList)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new hgf(this, paramList);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903126, null));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(paramContext);
  }
  
  public void a(CustomAlertDialog.OnOptionMenuClick paramOnOptionMenuClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnOptionMenuClick = paramOnOptionMenuClick;
  }
  
  public void a(CustomAlertDialog.OnPrepareOptionMenuItem paramOnPrepareOptionMenuItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnPrepareOptionMenuItem = paramOnPrepareOptionMenuItem;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -2);
    paramBundle = new WindowManager.LayoutParams(this.c, this.d, this.jdField_a_of_type_Int, this.b, 2, 0, -3);
    paramBundle.flags = 2;
    paramBundle.dimAmount = 0.5F;
    paramBundle.gravity = 51;
    getWindow().setAttributes(paramBundle);
    getWindow().getAttributes().windowAnimations = 2131624393;
    setCanceledOnTouchOutside(true);
    setContentView(this.jdField_a_of_type_AndroidWidgetListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomAlertDialog
 * JD-Core Version:    0.7.0.1
 */