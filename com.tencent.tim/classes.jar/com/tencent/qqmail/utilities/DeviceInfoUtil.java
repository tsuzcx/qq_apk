package com.tencent.qqmail.utilities;

import android.os.Build;
import android.os.Environment;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DeviceInfoUtil
{
  private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
  private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
  private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
  public static final String TAG = DeviceInfoUtil.class.getSimpleName();
  
  public static String getProperty(String paramString1, String paramString2)
  {
    label54:
    do
    {
      try
      {
        localFileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
        Properties localProperties;
        QMLog.log(6, TAG, "getProperty exception error 1," + paramString2.getMessage());
      }
      catch (IOException paramString2)
      {
        try
        {
          localProperties = new Properties();
          localProperties.load(localFileInputStream);
          paramString1 = localProperties.getProperty(paramString1, paramString2);
        }
        catch (IOException paramString2)
        {
          for (;;)
          {
            FileInputStream localFileInputStream;
            paramString1 = "";
          }
        }
        try
        {
          localFileInputStream.close();
          paramString2 = paramString1;
          return paramString2;
        }
        catch (IOException paramString2)
        {
          break label54;
        }
        paramString2 = paramString2;
        localFileInputStream = null;
        paramString1 = "";
      }
      paramString2 = paramString1;
    } while (localFileInputStream == null);
    try
    {
      localFileInputStream.close();
      return paramString1;
    }
    catch (IOException paramString2)
    {
      QMLog.log(6, TAG, "getProperty exception error 2," + paramString2.getMessage());
      return paramString1;
    }
  }
  
  public static boolean isHTC()
  {
    return Build.BRAND.toLowerCase().contains("htc");
  }
  
  public static boolean isMIUI()
  {
    return (!StringExtention.isNullOrEmpty(getProperty("ro.miui.ui.version.code", null))) || (!StringExtention.isNullOrEmpty(getProperty("ro.miui.ui.version.name", null))) || (!StringExtention.isNullOrEmpty(getProperty("ro.miui.internal.storage", null)));
  }
  
  public static boolean isSamsung()
  {
    return Build.BRAND.toLowerCase().contains("samsung");
  }
  
  public static boolean isSony()
  {
    return Build.BRAND.toLowerCase().contains("sony");
  }
  
  public static boolean isVivo()
  {
    return Build.BRAND.toLowerCase().contains("vivo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */