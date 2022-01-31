package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import epv;
import epw;
import epx;
import epy;
import epz;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  public static final int h = 1;
  public static final int i = 2;
  static final int j = 1;
  static final int k = 2;
  private View jdField_a_of_type_AndroidViewView;
  public PhoneContactManager a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private epz jdField_a_of_type_Epz;
  public QQProgressDialog b;
  
  public void a(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new epw(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Epz.obtainMessage(1, paramInt, 0);
    this.jdField_a_of_type_Epz.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 231, getString(2131559983), getString(2131559982), 2131559984, 2131559985, paramOnClickListener, new epx(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new epy(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new epv(this), null).show();
    }
  }
  
  protected String a_()
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    b(getResources().getString(paramInt));
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (!isFinishing())
    {
      b(paramInt);
      this.jdField_a_of_type_Epz.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  public void b(String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, 0, paramString, 0).b(d());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Epz.removeMessages(1);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Epz = new epz(this);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = null;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */