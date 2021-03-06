package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eyn;
import org.json.JSONObject;

public class VipUtils
{
  public static final int a = 1;
  public static final String a = "vip";
  public static final int b = 2;
  public static final String b = "svip";
  public static final int c = 4;
  public static final String c = "0";
  public static final String d = "1";
  public static final String e = "2";
  private static final String f = "VipUtils";
  
  public static int a(AppInterface paramAppInterface, String paramString)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppInterface.a();
      }
      paramAppInterface = (FriendsManagerImp)paramAppInterface.getManager(8);
      if (paramAppInterface == null) {
        break label128;
      }
      paramAppInterface = paramAppInterface.c(str);
      if (paramAppInterface == null) {
        break label110;
      }
      if (!paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label100;
      }
      i = 1;
      if (!paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label105;
      }
      j = 2;
      label76:
      if (paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        k = 4;
      }
      i = k | j | 0x0 | i;
    }
    label100:
    label105:
    label110:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label128:
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static void a(Activity paramActivity, eyn parameyn)
  {
    if ((parameyn == null) || (paramActivity == null) || (TextUtils.isEmpty(parameyn.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(parameyn.d)) || (TextUtils.isEmpty(parameyn.e)) || (TextUtils.isEmpty(parameyn.b)) || (TextUtils.isEmpty(parameyn.c)) || (parameyn.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", parameyn.b);
        ((JSONObject)localObject).put("aid", parameyn.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(parameyn.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", parameyn.e);
        ((JSONObject)localObject).put("serviceName", parameyn.c);
        ((JSONObject)localObject).put("userId", parameyn.jdField_a_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        if (parameyn.f == null) {
          break label210;
        }
        parameyn = parameyn.f;
        PayBridgeActivity.a(paramActivity, (String)localObject, 4, parameyn);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label210:
      parameyn = "";
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      eyn localeyn = new eyn();
      localeyn.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localeyn.d = paramString;
      localeyn.e = "1450000515";
      localeyn.b = "LTMCLUB";
      localeyn.c = paramBaseActivity.getString(2131364276);
      localeyn.jdField_a_of_type_Int = paramInt;
      localeyn.f = "vip";
      a(paramBaseActivity, localeyn);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "UNKNOWN";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      eyn localeyn = new eyn();
      localeyn.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localeyn.d = paramString;
      localeyn.e = "1450000516";
      localeyn.b = "CJCLUBT";
      localeyn.c = paramBaseActivity.getString(2131364323);
      localeyn.jdField_a_of_type_Int = paramInt;
      localeyn.f = "svip";
      a(paramBaseActivity, localeyn);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */