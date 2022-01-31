package com.tencent.mobileqq.activity.qwallet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QWalletPushManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "QWalletPushManager";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  
  static
  {
    a = new ArrayList();
  }
  
  public static int a()
  {
    if (a == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < a.size(); j = k)
    {
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      k = j;
      if (localPCPayData != null)
      {
        k = j;
        if (localPCPayData.f == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 9;
    case 2: 
      return 4;
    case 3: 
      return 11;
    case 4: 
      return 8;
    case 5: 
      return 7;
    }
    return 6;
  }
  
  private static QWalletPushManager.PCPayData a()
  {
    Object localObject;
    if (a == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= a.size()) {
        break label54;
      }
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 1) {
          break;
        }
      }
      i += 1;
    }
    label54:
    return null;
  }
  
  public static QWalletPushManager.PCPayData a(boolean paramBoolean)
  {
    Object localObject;
    if (a == null)
    {
      localObject = null;
      return localObject;
    }
    QWalletPushManager.PCPayData localPCPayData;
    if (paramBoolean)
    {
      i = a.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label101;
        }
        localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
        if (localPCPayData != null)
        {
          localObject = localPCPayData;
          if (localPCPayData.f == 0) {
            break;
          }
        }
        i -= 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= a.size()) {
        break label101;
      }
      localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 0) {
          break;
        }
      }
      i += 1;
    }
    label101:
    return null;
  }
  
  public static void a()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      int i = a.size() - 1;
      while (i >= 0)
      {
        QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
        if ((localPCPayData == null) || (localPCPayData.f == 1)) {
          a.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte) {}
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.isBackground_Pause) {
      return true;
    }
    try
    {
      paramQQAppInterface = BaseApplicationImpl.a();
      if (paramQQAppInterface == null) {
        return false;
      }
      Object localObject = (ActivityManager)paramQQAppInterface.getApplicationContext().getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null))
        {
          if (localRunningAppProcessInfo.processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!localRunningAppProcessInfo.processName.equals(paramQQAppInterface))
          {
            boolean bool = localRunningAppProcessInfo.processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
  
  public static void b()
  {
    if (a == null) {
      return;
    }
    a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPushManager
 * JD-Core Version:    0.7.0.1
 */