package com.tencent.mobileqq.activity.aio;

import android.support.v4.app.FragmentActivity;
import avsn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import wll;

public class IntimateInfoView$1
  implements Runnable
{
  public IntimateInfoView$1(wll paramwll, FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.c(this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity);
      avsn.d(this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_ComTencentMobileqqAppQQAppInterface);
      avsn.c(this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.1
 * JD-Core Version:    0.7.0.1
 */