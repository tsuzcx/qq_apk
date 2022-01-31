package com.tencent.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EUCountryUtils
{
  public static final int a = 0;
  private static final long a = 86400000L;
  public static final String a = "eu_birthday_bundle";
  public static final String[] a = { "43", "32", "359", "357", "385", "420", "45", "372", "358", "33", "49", "30", "36", "353", "39", "371", "370", "352", "356", "31", "48", "351", "40", "421", "386", "34", "46", "44", "354", "423", "47", "41", "90" };
  public static final int b = 1;
  private static final String b = "EUCountryUtils";
  public static final int c = 2;
  private static final String c = ":";
  public static final int d = 0;
  private static final String d = "mobileqqi_eu";
  public static final int e = 1;
  private static final String e = "eu_intercept_";
  public static final int f = 16;
  private static final String f = "eu_login_privacy";
  private static final String g = "eu_location";
  private static final String h = "eu_user";
  private static final String i = "eu_birthday";
  private static final String j = "eu_intercept";
  private static final String k = "eu_parent_access";
  
  public static int a(String paramString)
  {
    return a(paramString).getInt("eu_location", 0);
  }
  
  private static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("mobileqqi_eu", 0);
  }
  
  private static SharedPreferences a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileqqi_eu" + paramString, 0);
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return "*" + paramString.substring(paramString.length() - 4, paramString.length());
  }
  
  public static void a(String paramString)
  {
    String str = "eu_intercept_" + paramString;
    a().edit().putLong(str, System.currentTimeMillis()).commit();
    if (QLog.isColorLevel()) {
      QLog.d("EUCountryUtils", 2, "in EUCountryUtils add underage, phone :" + a(paramString));
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString).edit().putInt("eu_location", paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = a();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localObject = new HashSet(((SharedPreferences)localObject).getStringSet("eu_login_privacy", new HashSet()));
    paramString1 = new StringBuilder().append(paramString1).append(":");
    if (TextUtils.isEmpty(paramString2)) {
      paramString1.append("null");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EUCountryUtils", 2, "add Privacy Showed, finally add :" + paramString1.toString());
      }
      ((Set)localObject).add(paramString1.toString());
      localEditor.putStringSet("eu_login_privacy", (Set)localObject);
      localEditor.commit();
      return;
      String str = paramString1.toString() + "null";
      if ((((Set)localObject).size() > 0) && (((Set)localObject).contains(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EUCountryUtils", 2, "add Privacy Showed, contains tmpkey, to remove :" + str);
        }
        ((Set)localObject).remove(str);
      }
      paramString1.append(paramString2);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a(paramString).edit().putBoolean("eu_parent_access", paramBoolean).commit();
  }
  
  public static boolean a(int paramInt)
  {
    return a(ProfileUtil.a(paramInt));
  }
  
  public static boolean a(String paramString)
  {
    return ProfileUtil.a(paramString) < 16;
  }
  
  public static int b(String paramString)
  {
    return a(paramString).getInt("eu_user", 0);
  }
  
  public static void b(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    HashSet localHashSet = new HashSet(localSharedPreferences.getStringSet("eu_login_privacy", new HashSet()));
    int m = localHashSet.size();
    String str;
    String[] arrayOfString;
    if (m > 0)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (str != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EUCountryUtils", 2, "remove Privacy Showed, key :" + a(paramString) + ", getSP Properties:" + str);
          }
          arrayOfString = str.split(":");
          if (arrayOfString.length != 2) {
            break label197;
          }
          if ((paramString.equals(arrayOfString[0])) || (paramString.equals(arrayOfString[1]))) {
            localHashSet.remove(str);
          }
        }
      }
    }
    for (;;)
    {
      if (localHashSet.size() != m) {
        localSharedPreferences.edit().putStringSet("eu_login_privacy", localHashSet).commit();
      }
      return;
      label197:
      if ((arrayOfString.length != 1) || (!paramString.equals(arrayOfString[0]))) {
        break;
      }
      localHashSet.remove(str);
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    a(paramString).edit().putInt("eu_user", paramInt).commit();
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = a;
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramString.equals(arrayOfString[m])) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public static int c(String paramString)
  {
    return a(paramString).getInt("eu_birthday", 0);
  }
  
  public static void c(String paramString)
  {
    long l = System.currentTimeMillis();
    a(paramString).edit().putLong("eu_intercept", l).commit();
  }
  
  public static void c(String paramString, int paramInt)
  {
    a(paramString).edit().putInt("eu_birthday", paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("EUCountryUtils", 2, "to save EU Birthday:" + paramInt + ", current uin" + a(paramString));
    }
  }
  
  public static boolean c(String paramString)
  {
    paramString = "eu_intercept_" + paramString;
    long l = a().getLong(paramString, 0L);
    if (l <= 0L) {}
    while (System.currentTimeMillis() - l >= 86400000L) {
      return false;
    }
    return true;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    Object localObject1 = a().getStringSet("eu_login_privacy", new HashSet());
    if (((Set)localObject1).size() > 0) {
      localObject1 = ((Set)localObject1).iterator();
    }
    Object localObject2;
    do
    {
      do
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (localObject2 != null) {}
        }
        else
        {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EUCountryUtils", 2, "should Privacy Show By :" + a(paramString) + ", getSP Properties:" + (String)localObject2);
        }
        localObject2 = ((String)localObject2).split(":");
        if (localObject2.length != 2) {
          break;
        }
      } while ((!paramString.equals(localObject2[0])) && (!paramString.equals(localObject2[1])));
      return false;
    } while ((localObject2.length != 1) || (!paramString.equals(localObject2[0])));
    return false;
  }
  
  public static boolean e(String paramString)
  {
    long l = a(paramString).getLong("eu_intercept", 0L);
    return (l <= 0L) || (System.currentTimeMillis() - l > 86400000L);
  }
  
  public static boolean f(String paramString)
  {
    return a(paramString).getBoolean("eu_parent_access", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.EUCountryUtils
 * JD-Core Version:    0.7.0.1
 */