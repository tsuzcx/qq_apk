package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import hhh;

public class QQProgressNotifier
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  protected static final int h = 1;
  protected static final int i = 2;
  protected Handler a;
  public BaseActivity a;
  protected QQProgressDialog a;
  
  public QQProgressNotifier(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = new hhh(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt2), paramInt3);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = 0;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130903942);
    }
    if (paramInt1 == 0)
    {
      if ((paramString == null) || ("".equals(paramString.trim()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562875));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      }
    }
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130837949);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (paramInt2 <= 0) {
        break label283;
      }
    }
    label283:
    for (long l = paramInt2;; l = 1000L)
    {
      ((Handler)localObject).sendMessageDelayed(paramString, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130837960);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressNotifier
 * JD-Core Version:    0.7.0.1
 */