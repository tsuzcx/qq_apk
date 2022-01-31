package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public static boolean a;
  public static boolean b = false;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    QQToast.a(a(), paramString, 0).b(d());
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(a(), 231, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(a(), 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131560962, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(a(), 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void b(String paramString)
  {
    QQToast.a(a(), 2, paramString, 0).b(d());
  }
  
  public boolean c()
  {
    return NetworkUtil.e(BaseApplication.getContext());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public boolean f()
  {
    boolean bool = c();
    if (!bool) {
      a(getString(2131562452));
    }
    return bool;
  }
  
  public void finish()
  {
    e();
    f();
    super.finish();
  }
  
  protected void g() {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      return;
    }
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */