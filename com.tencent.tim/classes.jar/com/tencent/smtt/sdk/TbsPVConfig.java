package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

public class TbsPVConfig
  extends TbsBaseConfig
{
  private static TbsPVConfig b;
  public SharedPreferences mPreferences;
  
  public static TbsPVConfig getInstance(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        b = new TbsPVConfig();
        b.init(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getConfigFileName()
  {
    return "tbs_pv_config";
  }
  
  public int getDisabledCoreVersion()
  {
    try
    {
      String str = (String)this.a.get("disabled_core_version");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getEmergentCoreVersion()
  {
    try
    {
      String str = (String)this.a.get("emergent_core_version");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getLocalCoreVersionMoreTimes()
  {
    try
    {
      String str = (String)this.a.get("get_localcoreversion_moretimes");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getReadApk()
  {
    try
    {
      String str = (String)this.a.get("read_apk");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public String getSyncMapValue(String paramString)
  {
    try
    {
      paramString = (String)this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean getTbsCoreSandboxModeEnable()
  {
    try
    {
      bool = "true".equals((String)this.a.get("tbs_core_sandbox_mode_enable"));
      if (!bool) {
        break label37;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label37:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public boolean isDisableHostBackupCore()
  {
    try
    {
      String str = (String)this.a.get("disable_host_backup");
      if (TextUtils.isEmpty(str)) {
        break label46;
      }
      bool = str.equals("true");
      if (!bool) {
        break label46;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label46:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public boolean isEnableNoCoreGray()
  {
    try
    {
      String str = (String)this.a.get("enable_no_share_gray");
      if (TextUtils.isEmpty(str)) {
        break label46;
      }
      bool = str.equals("true");
      if (!bool) {
        break label46;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label46:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public void putData(String paramString1, String paramString2)
  {
    try
    {
      this.a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static abstract interface TbsPVConfigKey
  {
    public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
    public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
    public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
    public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
    public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
    public static final String KEY_READ_APK = "read_apk";
    public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPVConfig
 * JD-Core Version:    0.7.0.1
 */