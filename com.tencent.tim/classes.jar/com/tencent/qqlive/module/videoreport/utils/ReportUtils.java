package com.tencent.qqlive.module.videoreport.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ReportUtils
{
  private static volatile Context sContext;
  private static volatile Application sCurrentApplication;
  private static volatile boolean sGetCurrentApplicationChecked;
  private static PackageInfo sPackageInfo;
  
  public static long calcElementUniqueId(View paramView)
  {
    if (paramView == null) {}
    Object localObject2;
    do
    {
      return 0L;
      localObject2 = DataRWProxy.getElementId(paramView);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject1 = DataRWProxy.getInnerParam(paramView, "element_identifier");
    String str;
    if ((localObject1 instanceof String))
    {
      str = (String)localObject1;
      localObject2 = new StringBuilder().append((String)localObject2).append("_");
      if (TextUtils.isEmpty(str)) {
        break label84;
      }
    }
    label84:
    for (paramView = localObject1;; paramView = Integer.valueOf(paramView.hashCode()))
    {
      return paramView.toString().hashCode();
      str = null;
      break;
    }
  }
  
  @Nullable
  public static Context getContext()
  {
    if (sContext == null) {
      sContext = getCurrentApplication();
    }
    return sContext;
  }
  
  /* Error */
  private static Application getCurrentApplication()
  {
    // Byte code:
    //   0: getstatic 78	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sGetCurrentApplicationChecked	Z
    //   3: ifne +55 -> 58
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 78	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sGetCurrentApplicationChecked	Z
    //   12: istore_0
    //   13: iload_0
    //   14: ifne +41 -> 55
    //   17: ldc 80
    //   19: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: ldc 88
    //   24: iconst_0
    //   25: anewarray 82	java/lang/Class
    //   28: invokevirtual 92	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aconst_null
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 100	android/app/Application
    //   42: putstatic 102	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sCurrentApplication	Landroid/app/Application;
    //   45: getstatic 102	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sCurrentApplication	Landroid/app/Application;
    //   48: ifnull +7 -> 55
    //   51: iconst_1
    //   52: putstatic 78	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sGetCurrentApplicationChecked	Z
    //   55: ldc 2
    //   57: monitorexit
    //   58: getstatic 102	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sCurrentApplication	Landroid/app/Application;
    //   61: areturn
    //   62: astore_1
    //   63: iconst_1
    //   64: putstatic 78	com/tencent/qqlive/module/videoreport/utils/ReportUtils:sGetCurrentApplicationChecked	Z
    //   67: aload_1
    //   68: invokevirtual 105	java/lang/Throwable:printStackTrace	()V
    //   71: goto -16 -> 55
    //   74: astore_1
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	bool	boolean
    //   62	6	1	localThrowable	java.lang.Throwable
    //   74	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	55	62	java/lang/Throwable
    //   9	13	74	finally
    //   17	55	74	finally
    //   55	58	74	finally
    //   63	71	74	finally
    //   75	78	74	finally
  }
  
  public static int getPackageCode()
  {
    PackageInfo localPackageInfo = getPackageInfo();
    if (localPackageInfo != null) {
      return localPackageInfo.versionCode;
    }
    return -1;
  }
  
  private static PackageInfo getPackageInfo()
  {
    try
    {
      if (sPackageInfo == null) {
        sPackageInfo = sContext.getPackageManager().getPackageInfo(sContext.getPackageName(), 0);
      }
      label25:
      return sPackageInfo;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public static String getPackageName()
  {
    PackageInfo localPackageInfo = getPackageInfo();
    if (localPackageInfo != null) {
      return localPackageInfo.versionName;
    }
    return "";
  }
  
  public static void printStack(String paramString)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        Log.d(paramString, arrayOfStackTraceElement[i].toString());
        i += 1;
      }
    }
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ReportUtils
 * JD-Core Version:    0.7.0.1
 */