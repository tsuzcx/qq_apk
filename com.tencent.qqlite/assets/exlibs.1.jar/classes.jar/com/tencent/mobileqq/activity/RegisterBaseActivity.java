package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import bgz;
import bha;
import bhc;
import bhd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class RegisterBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public static final int d = 101;
  public static final int e = 102;
  public static final int f = 103;
  public Dialog a;
  protected ViewGroup a;
  private QQCustomDialog a;
  protected QQToastNotifier a;
  public Handler b = new bgz(this);
  public String c;
  public String d = "86";
  public String e;
  
  public void a(int paramInt)
  {
    try
    {
      this.b.post(new bhd(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.b.post(new bha(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364309, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public void g()
  {
    this.b.post(new bhc(this));
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
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
    paramDialogInterface.dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */