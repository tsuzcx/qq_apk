package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

public enum TbsPrivacyAccess
{
  @Deprecated
  private static boolean a = true;
  private boolean b;
  
  static
  {
    AndroidId = new TbsPrivacyAccess("AndroidId", 2, false);
    MacAddress = new TbsPrivacyAccess("MacAddress", 3, false);
    AndroidVersion = new TbsPrivacyAccess("AndroidVersion", 4, true);
    DeviceModel = new TbsPrivacyAccess("DeviceModel", 5, true);
    c = new TbsPrivacyAccess[] { DeviceId, Imsi, AndroidId, MacAddress, AndroidVersion, DeviceModel };
  }
  
  private TbsPrivacyAccess(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private static void a(SharedPreferences.Editor paramEditor, ConfigurablePrivacy paramConfigurablePrivacy, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramEditor.putString(paramConfigurablePrivacy.a, paramString);
      TbsLog.i("TbsPrivacy", "configurePrivacy " + paramConfigurablePrivacy.a + " is " + paramString);
    }
  }
  
  public static void configureAllPrivacy(Context paramContext, Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getSharedPreferences("uifa", 0).edit();
        ConfigurablePrivacy[] arrayOfConfigurablePrivacy = ConfigurablePrivacy.values();
        int j = arrayOfConfigurablePrivacy.length;
        if (i < j)
        {
          ConfigurablePrivacy localConfigurablePrivacy = arrayOfConfigurablePrivacy[i];
          if (paramBundle.containsKey(localConfigurablePrivacy.a)) {
            a(paramContext, localConfigurablePrivacy, paramBundle.getString(localConfigurablePrivacy.a));
          }
        }
        else
        {
          paramContext.putString("app_call", "done");
          paramContext.commit();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void configureAllPrivacy(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("uifa", 0).edit();
      paramContext.putString("app_list", paramString);
      paramContext.putString("app_call", "done");
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void configurePrivacy(Context paramContext, ConfigurablePrivacy paramConfigurablePrivacy, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("uifa", 0).edit();
    a(paramContext, paramConfigurablePrivacy, paramString);
    paramContext.commit();
  }
  
  @Deprecated
  public static void disableSensitiveApi()
  {
    a = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("no_sensitive_api", Boolean.valueOf(true));
    QbSdk.initTbsSettings(localHashMap);
  }
  
  public static String getConfigurePrivacy(Context paramContext, ConfigurablePrivacy paramConfigurablePrivacy, String paramString)
  {
    return paramContext.getSharedPreferences("uifa", 0).getString(paramConfigurablePrivacy.a, paramString);
  }
  
  @Deprecated
  public static boolean isEnableSensitiveApi()
  {
    return a;
  }
  
  public boolean isDisabled()
  {
    return !this.b;
  }
  
  public boolean isEnabled()
  {
    return this.b;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
    Log.d("TbsPrivacy", name() + " is " + paramBoolean);
    TbsLog.i("TbsPrivacy", name() + " is " + paramBoolean);
  }
  
  public static enum ConfigurablePrivacy
  {
    String a;
    
    static
    {
      ANDROID_ID = new ConfigurablePrivacy("ANDROID_ID", 1, "android_id");
      MAC = new ConfigurablePrivacy("MAC", 2, "mac");
    }
    
    private ConfigurablePrivacy(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPrivacyAccess
 * JD-Core Version:    0.7.0.1
 */