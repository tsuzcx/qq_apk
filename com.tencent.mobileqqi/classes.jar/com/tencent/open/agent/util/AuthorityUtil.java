package com.tencent.open.agent.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.settings.OpensdkPreference;

public class AuthorityUtil
{
  protected static final String a = "AuthorityUtil";
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    LogUtility.b("AuthorityUtil", "getOpenId uin = " + paramString1 + ", appid = " + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return OpensdkPreference.a(paramContext, "uin_openid_store").getString(paramString2 + ":" + paramString1, null);
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "0";
      }
      paramString = paramString.substring(paramString.length() - 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthorityUtil
 * JD-Core Version:    0.7.0.1
 */