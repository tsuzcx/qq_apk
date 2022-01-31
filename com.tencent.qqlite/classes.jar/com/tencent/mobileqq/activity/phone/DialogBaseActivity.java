package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import cim;
import cin;
import cio;
import cip;
import ciq;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  public static final int b = 1;
  public static final int c = 2;
  static final int d = 1;
  static final int e = 2;
  private View jdField_a_of_type_AndroidViewView;
  private ciq jdField_a_of_type_Ciq;
  public PhoneContactManager a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  
  public void a(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new cin(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    if (!isFinishing())
    {
      b(paramInt);
      this.jdField_a_of_type_Ciq.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 231, getString(2131362088), getString(2131362087), 2131362089, 2131362090, paramOnClickListener, new cio(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new cip(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, 0, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new cim(this), null).show();
    }
  }
  
  public void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void b(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Ciq.obtainMessage(1, paramInt, 0);
    this.jdField_a_of_type_Ciq.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected String b_()
  {
    return null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ciq.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Ciq = new ciq(this);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.app.getManager(10));
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
    this.jdField_a_of_type_AndroidViewView = setContentViewB(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */