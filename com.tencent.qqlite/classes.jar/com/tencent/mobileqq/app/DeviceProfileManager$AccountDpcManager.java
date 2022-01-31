package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.manager.Manager;

public class DeviceProfileManager$AccountDpcManager
  implements Manager
{
  public static HashSet a;
  public QQAppInterface a;
  private String a;
  public HashMap a;
  public HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public DeviceProfileManager$AccountDpcManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    if (QLog.isColorLevel()) {
      QLog.i(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "AccountDpcManager init() " + paramQQAppInterface.a().substring(paramQQAppInterface.a().length() - 5));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = MsgProxyUtils.a(paramQQAppInterface.a());
    b();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    return MsgProxyUtils.a(paramQQAppInterface.a()) + "_" + paramString;
  }
  
  private String a(String paramString)
  {
    return this.jdField_a_of_type_JavaLangString + "_" + paramString;
  }
  
  private void a()
  {
    DeviceProfileManager.AccountDpcManager.DpcAccountNames[] arrayOfDpcAccountNames = DeviceProfileManager.AccountDpcManager.DpcAccountNames.values();
    int j = arrayOfDpcAccountNames.length;
    int i = 0;
    while (i < j)
    {
      DeviceProfileManager.AccountDpcManager.DpcAccountNames localDpcAccountNames = arrayOfDpcAccountNames[i];
      this.b.put(a(localDpcAccountNames.name()), new DeviceProfileManager.DPCConfigInfo());
      jdField_a_of_type_JavaUtilHashSet.add(localDpcAccountNames.name());
      i += 1;
    }
  }
  
  private void b()
  {
    a();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig_account");
    DeviceProfileManager.AccountDpcManager.DpcAccountNames[] arrayOfDpcAccountNames = DeviceProfileManager.AccountDpcManager.DpcAccountNames.values();
    int j = arrayOfDpcAccountNames.length;
    int i = 0;
    if (i < j)
    {
      String str1 = a(arrayOfDpcAccountNames[i].name());
      String str2 = localSharedPreferences.getString(str1, "");
      DeviceProfileManager.DPCConfigInfo localDPCConfigInfo;
      if ("".equals(str2)) {
        localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.b.get(str1)).clone();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, localDPCConfigInfo);
        if (QLog.isColorLevel()) {
          QLog.i(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "init loop mFeatureMapLV2_account MAP: " + str1 + "=" + localDPCConfigInfo.toString());
        }
        i += 1;
        break;
        localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
        DeviceProfileManager.a(localDPCConfigInfo, str2);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "AccountDpcManager onDestroy()");
    }
    synchronized (DeviceProfileManager.a())
    {
      DeviceProfileManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      DeviceProfileManager.a().a(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager
 * JD-Core Version:    0.7.0.1
 */