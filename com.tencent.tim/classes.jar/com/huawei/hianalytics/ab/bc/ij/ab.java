package com.huawei.hianalytics.ab.bc.ij;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
public class ab
{
  public static String ab(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageName();
    return "hms_" + paramString + "_" + paramContext;
  }
  
  public static void ab(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return;
      paramContext = de(paramContext, paramString1);
    } while (paramContext == null);
    paramContext = paramContext.edit();
    paramContext.putLong(paramString2, paramLong);
    paramContext.commit();
  }
  
  public static void ab(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return;
      paramContext = de(paramContext, paramString1);
    } while (paramContext == null);
    paramContext = paramContext.edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
  }
  
  public static void ab(Context paramContext, String paramString, String... paramVarArgs)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "clearData(): parameter error.context,spname");
    }
    for (;;)
    {
      return;
      if (paramVarArgs == null)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "clearData(): No data need to be deleted,keys is null");
        return;
      }
      paramContext = de(paramContext, paramString);
      if (paramContext != null)
      {
        paramString = paramContext.edit();
        if (paramVarArgs.length == 0)
        {
          paramString.clear();
          paramString.commit();
          return;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          String str = paramVarArgs[i];
          if (paramContext.contains(str))
          {
            paramString.remove(str);
            paramString.commit();
          }
          i += 1;
        }
      }
    }
  }
  
  public static long bc(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return paramLong;
      paramContext = de(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext.getLong(paramString2, paramLong);
  }
  
  public static String bc(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return paramString3;
      paramContext = de(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext.getString(paramString2, paramString3);
  }
  
  public static Map<String, ?> bc(Context paramContext, String paramString)
  {
    return de(paramContext, paramString).getAll();
  }
  
  public static void cd(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("SharedPreUtils", "clearTypeDataByTag() eventTag is null or empty!");
      return;
    }
    if ("_default_config_tag".equals(paramString))
    {
      ab(paramContext, "stat_v2_1", new String[] { paramString });
      ab(paramContext, "cached_v2_1", new String[] { paramString });
      return;
    }
    String str1 = paramString + "-" + "oper";
    String str2 = paramString + "-" + "maint";
    paramString = paramString + "-" + "diffprivacy";
    ab(paramContext, "stat_v2_1", new String[] { str1 });
    ab(paramContext, "cached_v2_1", new String[] { str1 });
    ab(paramContext, "stat_v2_1", new String[] { str2 });
    ab(paramContext, "cached_v2_1", new String[] { str2 });
    ab(paramContext, "stat_v2_1", new String[] { paramString });
    ab(paramContext, "cached_v2_1", new String[] { paramString });
  }
  
  private static SharedPreferences de(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(ab(paramContext, paramString), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ij.ab
 * JD-Core Version:    0.7.0.1
 */