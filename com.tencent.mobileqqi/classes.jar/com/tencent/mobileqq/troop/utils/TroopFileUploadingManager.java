package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import gya;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public static final String a = "TroopFileUploadingManager";
  public BizTroopObserver a;
  public QQAppInterface a;
  
  public TroopFileUploadingManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new gya(this);
  }
  
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
      if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager != null) && (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.c(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = new TroopFileUploadingManager();
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager
 * JD-Core Version:    0.7.0.1
 */