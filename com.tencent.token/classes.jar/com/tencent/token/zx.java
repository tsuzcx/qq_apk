package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import java.io.File;

public final class zx
{
  public static boolean a(Context paramContext, String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramString = FileProvider.a(paramContext, "com.tencent.token.FileProvider", paramString);
        localIntent.addFlags(1);
      }
      else
      {
        paramString = Uri.fromFile(paramString);
      }
      localIntent.setDataAndType(paramString, "application/vnd.android.package-archive");
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext != null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(paramContext.getPackageManager().getLaunchIntentForPackage(paramString));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zx
 * JD-Core Version:    0.7.0.1
 */