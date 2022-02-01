package com.tencent.qqmail.utilities;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;

public class InstallUtils
{
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String TAG = "InstallUtils";
  private static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
  private static final String WEWORK_PACKAGE_NAME = "com.tencent.wework";
  
  public static boolean comfirmAppInstalled(String paramString)
  {
    try
    {
      paramString = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        Log.i("InstallUtils", "Not installed");
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      Log.i("InstallUtils", "Have installed");
    }
    return true;
  }
  
  public static boolean isQQInstalled()
  {
    return comfirmAppInstalled("com.tencent.mobileqq");
  }
  
  public static boolean isWeChatInstalled()
  {
    return comfirmAppInstalled("com.tencent.mm");
  }
  
  public static boolean isWeWorkInstalled()
  {
    return comfirmAppInstalled("com.tencent.wework");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.InstallUtils
 * JD-Core Version:    0.7.0.1
 */