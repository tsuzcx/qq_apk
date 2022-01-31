package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileManagerReporter
{
  private static final String a = "<FileAssistant>FileManagerReporter";
  private static final String b = "fileAssistantRePort";
  private static final String c = "fileAssistantRePort_SetKey";
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    BaseApplication.getContext().getSharedPreferences(paramQQAppInterface + "fileAssistantRePort", 0).edit().clear().commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramQQAppInterface.a();
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(str + "fileAssistantRePort", 0);
    Object localObject1 = localSharedPreferences.getString("fileAssistantRePort_SetKey", "").split("@_@");
    Object localObject2 = new HashSet();
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = localObject1[i];
      if ((localObject3 == null) || (localObject3.length() < 0) || (localObject3.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        ((Set)localObject2).add(localObject3);
      }
    }
    localObject1 = ((Set)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (QLog.isColorLevel()) {
        QLog.d("<FileAssistant>FileManagerReporter", 2, "reported[" + (String)localObject2 + "]");
      }
      i = localSharedPreferences.getInt((String)localObject2, 0);
      if (i != 0)
      {
        localObject2 = FileManagerReporter.fileAssistantReportData.a((String)localObject2, i);
        if (localObject2 != null)
        {
          if (((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Boolean) {}
          for (i = 0;; i = 1)
          {
            StatisticCollector.a(paramActivity).a(paramQQAppInterface, str, "", FileManagerReporter.fileAssistantReportData.a((FileManagerReporter.fileAssistantReportData)localObject2), ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_JavaLangString, ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int, ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_Int, i, String.valueOf(((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_Long), ((FileManagerReporter.fileAssistantReportData)localObject2).c, FileManagerReporter.fileAssistantReportData.b((FileManagerReporter.fileAssistantReportData)localObject2), ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString);
            break;
          }
        }
      }
    }
    a(paramQQAppInterface);
  }
  
  public static void a(String paramString, FileManagerReporter.fileAssistantReportData paramfileAssistantReportData)
  {
    paramString = BaseApplication.getContext().getSharedPreferences(paramString + "fileAssistantRePort", 0);
    Object localObject2 = paramString.getString("fileAssistantRePort_SetKey", "").split("@_@");
    Object localObject1 = new HashSet();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = localObject2[i];
      if ((localObject3 == null) || (localObject3.length() < 0) || (localObject3.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        ((Set)localObject1).add(localObject3);
      }
    }
    paramfileAssistantReportData = paramfileAssistantReportData.a();
    ((Set)localObject1).add(paramfileAssistantReportData);
    localObject2 = new StringBuilder();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject2).append((String)((Iterator)localObject1).next());
      ((StringBuilder)localObject2).append("@_@");
    }
    paramString.edit().putString("fileAssistantRePort_SetKey", ((StringBuilder)localObject2).toString()).commit();
    i = paramString.getInt(paramfileAssistantReportData, 0);
    paramString.edit().putInt(paramfileAssistantReportData, i + 1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerReporter
 * JD-Core Version:    0.7.0.1
 */