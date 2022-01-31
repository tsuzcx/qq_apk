package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class StreamParams
{
  private static final String jdField_a_of_type_JavaLangString = "StreamParams";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b = true;
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).getString("StreamCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "getSavedStreamCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).edit().putString("StreamCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "saveStreamCfg: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((a) && (!paramBoolean)) {
      return;
    }
    a = true;
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "init");
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("StreamParams", 2, "init from sp:" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          int i = paramQQAppInterface.length();
          if (i != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StreamParams", 2, "init params: " + b);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 1)) {
        b = "1".equals(paramQQAppInterface[0]);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, false);
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.StreamParams
 * JD-Core Version:    0.7.0.1
 */