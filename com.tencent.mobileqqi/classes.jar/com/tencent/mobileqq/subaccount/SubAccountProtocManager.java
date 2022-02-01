package com.tencent.mobileqq.subaccount;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindHandler;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.qphone.base.util.QLog;
import glj;
import glk;
import mqq.manager.Manager;

public class SubAccountProtocManager
  implements Manager
{
  private static final long jdField_a_of_type_Long = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountProtocManager";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new glj(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new glk(this);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  
  public SubAccountProtocManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountProtocManager", 2, "SubAccountProtocManager: manager init");
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
    }
    this.jdField_c_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16)).a();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    this.jdField_b_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16)).a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    ((SubAccountBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16)).a(paramString1, paramString2);
  }
  
  public boolean a()
  {
    synchronized (jdField_c_of_type_ArrayOfByte)
    {
      boolean bool = this.d;
      return bool;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountProtocManager
 * JD-Core Version:    0.7.0.1
 */