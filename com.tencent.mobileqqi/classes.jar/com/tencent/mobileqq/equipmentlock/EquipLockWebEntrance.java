package com.tencent.mobileqq.equipmentlock;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

public class EquipLockWebEntrance
{
  public static final String a = "EquipLockWebEntrance";
  
  private static Intent a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramActivity == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent actCaller is null");
      }
    }
    do
    {
      return null;
      if (paramQQAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent app is null");
    return null;
    String str = paramQQAppInterface.a();
    paramQQAppInterface = a(a(), paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + paramQQAppInterface);
    }
    paramActivity = new Intent(paramActivity, QQBrowserActivity.class);
    paramActivity.putExtra("portraitOnly", true);
    paramActivity.putExtra("url", paramQQAppInterface);
    paramActivity.putExtra("uin", str);
    paramActivity.putExtra("hide_operation_bar", true);
    paramActivity.putExtra("hide_more_button", true);
    return paramActivity;
  }
  
  private static String a()
  {
    Object localObject = EquipmentLockImpl.a().a();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      if (!((String)localObject).startsWith("http")) {}
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("plat=1");
      ((StringBuilder)localObject).append("&app=1");
      ((StringBuilder)localObject).append("&version=6.0.3.6604");
      ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      return ((StringBuilder)localObject).toString();
      localObject = "http://" + (String)localObject;
      continue;
      localObject = "http://aq.qq.com/cn2/manage/mobile_h5/mobile_index";
    }
  }
  
  private static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    String str = null;
    if (paramString == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "handlePhoneContact url is null");
      }
    }
    for (;;)
    {
      return paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null)
          {
            if (!QLog.isColorLevel()) {
              break label250;
            }
            QLog.d("EquipLockWebEntrance", 2, "mgr can't find stat");
            paramQQAppInterface = null;
          }
        }
      }
      while ((str != null) && (str.length() > 0) && (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        paramString = new StringBuilder(paramString);
        paramString.append("&area=" + str);
        paramString.append("&mob=" + paramQQAppInterface);
        return paramString.toString();
        if (QLog.isColorLevel()) {
          QLog.d("EquipLockWebEntrance", 2, "mgr find stat, nationCode=" + paramQQAppInterface.nationCode + " no.=" + paramQQAppInterface.mobileNo);
        }
        str = paramQQAppInterface.nationCode;
        paramQQAppInterface = paramQQAppInterface.mobileNo;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("EquipLockWebEntrance", 2, "mgr is null");
        }
        for (;;)
        {
          str = null;
          paramQQAppInterface = localObject;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "getEntranceIntent:app is null");
          }
        }
        label250:
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enter actCaller is null");
      }
      return;
    }
    paramQQAppInterface = a(paramActivity, paramQQAppInterface);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, paramQQAppInterface, false, -1);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramActivity == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "enterForResult actCaller is null");
      }
    }
    do
    {
      return;
      if (paramQQAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EquipLockWebEntrance", 4, "enterForResult app is null");
    return;
    paramQQAppInterface = a(paramActivity, paramQQAppInterface);
    if (paramString != null) {
      paramQQAppInterface.putExtra("tag", paramString);
    }
    paramQQAppInterface.putExtra("needResult", true);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, paramQQAppInterface, true, paramInt);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramActivity == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
      }
      return;
    }
    String str = a();
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + str);
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", str);
    localIntent.putExtra("subAccountUin", paramString2);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    boolean bool1;
    if ((paramString1 == null) || (paramString1.equals(paramString2)))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(BaseActivity.a.getAppRuntime().getAccount()))
        {
          bool1 = bool2;
          if (!BaseActivity.a.getAppRuntime().getAccount().equals(paramString2)) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EquipLockWebEntrance", 2, "globalEnter currentUin=" + paramString1 + " reqUin=" + paramString2 + " isSubaccount=" + bool1);
    }
    localIntent.putExtra("isSubaccount", bool1);
    localIntent.putExtra("avoidLoginWeb", bool1);
    try
    {
      VasWebviewUtil.a(paramActivity, "", 16384L, localIntent, false, -1);
      return;
    }
    catch (SecurityException paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance
 * JD-Core Version:    0.7.0.1
 */