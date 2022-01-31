package com.tencent.mobileqq.filemanager.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UniformDownloadUtil
{
  private static final String a = "UniformDownloadUtil";
  
  public static int a(String paramString)
  {
    if (b(paramString) == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK failed.  is not apk file. PH:" + paramString);
      return -1;
    }
    try
    {
      if (!new File(paramString).exists())
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK. file is not exsited. PH:" + paramString);
        return -2;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      FileProvider7Helper.installApkFile(BaseApplication.getContext(), paramString);
      BaseApplication.getContext().startActivity(localIntent);
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK. Exception 2");
      paramString.printStackTrace();
    }
    return -3;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject3 = new DisplayMetrics();
      ((DisplayMetrics)localObject3).setToDefaults();
      localObject1 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE }).invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
      localObject1 = (ApplicationInfo)localObject1.getClass().getDeclaredField("applicationInfo").get(localObject1);
      localObject3 = Class.forName("android.content.res.AssetManager");
      localObject2 = ((Class)localObject3).newInstance();
      ((Class)localObject3).getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = BaseApplication.getContext().getResources();
      paramString = (Resources)Resources.class.getConstructor(new Class[] { localObject2.getClass(), paramString.getDisplayMetrics().getClass(), paramString.getConfiguration().getClass() }).newInstance(new Object[] { localObject2, paramString.getDisplayMetrics(), paramString.getConfiguration() });
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).icon != 0))
      {
        paramString = BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = Uri.parse(paramString);
    } while (paramString == null);
    return paramString.getLastPathSegment();
  }
  
  public static void a(String paramString)
  {
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString);
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString);
      return;
    }
    Context localContext = BaseApplication.getContext();
    String str = MimeTypesTools.a(localContext, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
    try
    {
      localContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + paramString);
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (localObject == null) {
          break label86;
        }
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
        if (localObject != null) {
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
        paramString.printStackTrace();
        return null;
      }
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + paramString);
      return null;
      label86:
      Object localObject = null;
    }
  }
  
  public static String c(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label161;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      i = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new File(str2);
        i += 1;
      }
      label161:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadUtil
 * JD-Core Version:    0.7.0.1
 */