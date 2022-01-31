package com.tencent.biz.thridappshare;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class DataProviderApi
{
  public static final String a = "tencent%s.provider://";
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString2));
    localIntent.putExtra("srcAction", paramString3);
    localIntent.putExtra("srcPackageName", paramString4);
    localIntent.putExtra("srcClassName", paramString5);
    localIntent.putExtra("params_appid", paramString1);
    try
    {
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (ActivityNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString1));
    if (localPackageManager.queryIntentActivities(localIntent, 0).size() != 0)
    {
      if (a(paramContext, paramString2, paramString1, paramString3, paramString4, paramString5)) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataProviderApi", 2, "start scheme:" + paramString1 + " failed!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataProviderApi", 2, "scheme:" + paramString1 + " is not found!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.thridappshare.DataProviderApi
 * JD-Core Version:    0.7.0.1
 */