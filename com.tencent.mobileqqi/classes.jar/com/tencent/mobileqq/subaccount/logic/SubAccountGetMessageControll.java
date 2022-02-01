package com.tencent.mobileqq.subaccount.logic;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.QLog;
import glo;
import glp;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class SubAccountGetMessageControll
  implements Manager
{
  private static final long jdField_a_of_type_Long = 300L;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountGetMessageControll";
  private int jdField_a_of_type_Int = 0;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new glo(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private glp jdField_a_of_type_Glp = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private long jdField_b_of_type_Long = 300L;
  private boolean jdField_b_of_type_Boolean = true;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  
  public SubAccountGetMessageControll(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "SubAccountGetMessageControll：");
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    String str1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
    {
      str1 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = SubAccountAssistantImpl.a().a(str1);
      ??? = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(25);
      if (??? == null) {
        break label157;
      }
      boolean bool = ((SubAccountProtocManager)???).a();
      if (bool) {
        break label157;
      }
      ??? = new SubAccountBackProtocData();
      ((SubAccountBackProtocData)???).a = "";
      ((SubAccountBackProtocData)???).b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      ((SubAccountBackProtocData)???).c = str1;
      ((SubAccountBackProtocData)???).p = 1009;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8003, false, ???);
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "getSubAccountMessage： get bind subaccount isFinish = " + bool);
      }
    }
    return false;
    label157:
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Int += 1;
        }
        return true;
      }
      this.jdField_a_of_type_Int = 0;
      if ((str1 == null) || (str1.length() == 0) || (localObject2 == null) || (((String)localObject2).length() == 0) || (((String)localObject2).trim().equals("")))
      {
        this.jdField_a_of_type_Boolean = false;
        localObject2 = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject2).a = "";
        ((SubAccountBackProtocData)localObject2).b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        ((SubAccountBackProtocData)localObject2).c = str1;
        ((SubAccountBackProtocData)localObject2).p = 1010;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8003, false, localObject2);
        return false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "getSubAccountMessage： lockMsg later  really start get subaccount message account = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "; sAccount = " + str2);
    }
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a().a((byte)3, 0, str2, (String)localObject2, null);
    return true;
  }
  
  private void b()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
      if ((str != null) && (!TextUtils.isEmpty(str)))
      {
        this.jdField_b_of_type_Long = Long.parseLong(str);
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountGetMessageControll", 2, "initConfig： mConfigDelayTime = " + this.jdField_b_of_type_Long);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_Int = 0;
    }
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Glp != null)
      {
        this.jdField_a_of_type_Glp.a();
        this.jdField_a_of_type_Glp = null;
        this.jdField_b_of_type_Boolean = true;
      }
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Glp == null)
      {
        this.jdField_a_of_type_Glp = new glp(this, null);
        new Thread(this.jdField_a_of_type_Glp, "Q.subaccount.SubAccountGetMessageControll").start();
        return;
      }
      glp.a(this.jdField_a_of_type_Glp, paramBoolean);
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountGetMessageControll
 * JD-Core Version:    0.7.0.1
 */