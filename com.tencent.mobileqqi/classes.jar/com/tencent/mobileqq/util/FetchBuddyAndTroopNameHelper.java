package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.QQAppInterface;
import hes;

public class FetchBuddyAndTroopNameHelper
{
  private static final String jdField_a_of_type_JavaLangString = FetchBuddyAndTroopNameHelper.class.getSimpleName();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FetchInfoListManager jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = null;
  
  public FetchBuddyAndTroopNameHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FetchInfoListManager a()
  {
    return new FetchInfoListManager(new hes(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(2, paramString, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(3, paramString1, paramString2, paramString3);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(1, paramString, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper
 * JD-Core Version:    0.7.0.1
 */