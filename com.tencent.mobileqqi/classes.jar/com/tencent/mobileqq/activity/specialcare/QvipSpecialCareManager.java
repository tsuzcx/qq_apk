package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareHandler;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QvipSpecialCareManager
{
  public static final int a = 13568;
  private static final String jdField_a_of_type_JavaLangString = "SpecialCareManager";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public QvipSpecialCareManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getInt("special_sound_quota" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2);
  }
  
  public int a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getInt("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramString, 0);
  }
  
  public long a()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getLong("key_get_special_sound_quota_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0L);
  }
  
  public Set a()
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    new HashSet();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      return localObject2;
    }
  }
  
  public void a()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    localEditor.putLong("key_get_special_sound_quota_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    localEditor.putInt("special_sound_quota" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public void a(String paramString)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Set localSet = SharedPreferencesHandler.a((SharedPreferences)localObject1, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      localObject1 = localSet;
      if (localSet == null) {
        localObject1 = new HashSet();
      }
      if (((Set)localObject1).contains(paramString)) {
        return;
      }
      ((Set)localObject1).add(paramString);
      paramString = ((Set)localObject1).toArray();
      SharedPreferencesHandler.a(localEditor, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    localEditor.putInt("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramString, paramInt);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (a(paramString1)) {
        b(paramString1);
      }
      if (b(paramString1)) {
        c(paramString1);
      }
    }
    do
    {
      return;
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!a(paramString1)) {
          a(paramString1);
        }
        a(paramString1, i);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.i("SpecialCareManager", 2, "dealWithRespSound|exception = " + paramString1.toString());
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    label185:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject1 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
        if (localObject1 != null) {
          break label185;
        }
        localObject1 = new HashSet();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (((Set)localObject1).contains(str)) {
            continue;
          }
          ((Set)localObject1).add(str);
        }
      }
      paramList = ((Set)localObject1).toArray();
      SharedPreferencesHandler.a(localEditor, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramList).commit();
      return;
    }
  }
  
  public void a(List paramList1, int paramInt, List paramList2)
  {
    QvipSpecialCareHandler localQvipSpecialCareHandler = (QvipSpecialCareHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(14);
    if (localQvipSpecialCareHandler != null) {
      localQvipSpecialCareHandler.a(paramList1, paramInt, paramList2);
    }
  }
  
  public void a(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      int i = ((Integer)localEntry.getValue()).intValue();
      localEditor.putInt("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + str, i);
    }
    localEditor.commit();
  }
  
  public boolean a(String paramString)
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    new HashSet();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()) && (((Set)localObject2).contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getInt("special_sound_svip_quota" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 20);
  }
  
  public void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    localEditor.putInt("special_sound_svip_quota" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public void b(String paramString)
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      if (localObject2 != null)
      {
        if (!((Set)localObject2).contains(paramString)) {
          return;
        }
        ((Set)localObject2).remove(paramString);
        paramString = ((Set)localObject2).toArray();
        SharedPreferencesHandler.a(localEditor, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
      }
      return;
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      if (localObject2 == null) {
        break label180;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (((Set)localObject2).contains(str)) {
          ((Set)localObject2).remove(str);
        }
      }
    }
    paramList = ((Set)localObject2).toArray();
    SharedPreferencesHandler.a(localEditor, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramList).commit();
    label180:
  }
  
  public boolean b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).contains("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramString);
  }
  
  public int c()
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    new HashSet();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      if (localObject2 != null) {
        return ((Set)localObject2).size();
      }
    }
    return 0;
  }
  
  public void c(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    localEditor.remove("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramString);
    localEditor.commit();
  }
  
  public void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localEditor.remove("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + str);
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager
 * JD-Core Version:    0.7.0.1
 */