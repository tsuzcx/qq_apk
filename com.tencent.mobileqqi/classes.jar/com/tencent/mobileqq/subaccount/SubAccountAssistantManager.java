package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class SubAccountAssistantManager
{
  private static SubAccountAssistantImpl jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl = null;
  private static SubAccountAssistantManager jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountAssistantManager";
  public static final boolean a = true;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager = null;
  }
  
  public static SubAccountAssistantManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager == null)
      {
        jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager = new SubAccountAssistantManager();
        jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl = SubAccountAssistantImpl.a();
      }
      return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager;
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface, paramString);
  }
  
  public String a()
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a();
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface, paramString);
  }
  
  public String a(String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramString);
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean("subaccount_ug_show" + paramString, paramBoolean).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.b(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a(ProxyManager paramProxyManager, long paramLong) {}
  
  public boolean a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("subaccount_ug_show" + paramString, true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl.a(paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountAssistantManager
 * JD-Core Version:    0.7.0.1
 */