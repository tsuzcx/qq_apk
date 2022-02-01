package com.tencent.qqmail.marcos;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Properties;

public final class AppConfig
{
  private static boolean BETA = false;
  private static boolean COVTEST = false;
  private static boolean LIMITED = false;
  private static boolean LOGCAT = false;
  private static final String TAG = "AppConfig";
  private static int systemVersionCode = -1;
  @NonNull
  private static String systemVersionName;
  
  @NonNull
  public static String getCodeVersion()
  {
    return getCodeVersionName() + "." + getPatchVersionCode();
  }
  
  @NonNull
  public static String getCodeVersionName()
  {
    return "5.3.3";
  }
  
  public static int getMajorVersion(Context paramContext)
  {
    int i = -1;
    paramContext = getSystemVersionName().split("\\.");
    if (paramContext.length != 0) {
      i = Integer.parseInt(paramContext[0]);
    }
    return i;
  }
  
  @NonNull
  public static String getPatchVersion()
  {
    return getSystemVersionName() + "." + getPatchVersionCode();
  }
  
  public static int getPatchVersionCode()
  {
    return 625;
  }
  
  /* Error */
  private static Properties getProperties(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 87	java/util/Properties
    //   3: dup
    //   4: invokespecial 88	java/util/Properties:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 94	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: aload_1
    //   18: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_0
    //   22: aload_0
    //   23: astore_2
    //   24: aload_0
    //   25: astore_3
    //   26: aload 4
    //   28: aload_0
    //   29: invokevirtual 104	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   32: aload_0
    //   33: invokevirtual 109	java/io/InputStream:close	()V
    //   36: aload 4
    //   38: areturn
    //   39: astore_0
    //   40: aload_2
    //   41: astore_3
    //   42: aload_0
    //   43: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   46: aload_2
    //   47: invokevirtual 109	java/io/InputStream:close	()V
    //   50: aload 4
    //   52: areturn
    //   53: astore_0
    //   54: aload 4
    //   56: areturn
    //   57: astore_0
    //   58: aload_3
    //   59: invokevirtual 109	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: aload 4
    //   67: areturn
    //   68: astore_1
    //   69: goto -7 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramContext	Context
    //   0	72	1	paramString	String
    //   12	35	2	localContext	Context
    //   10	49	3	localObject	Object
    //   7	59	4	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   13	22	39	java/lang/Exception
    //   26	32	39	java/lang/Exception
    //   46	50	53	java/lang/Exception
    //   13	22	57	finally
    //   26	32	57	finally
    //   42	46	57	finally
    //   32	36	64	java/lang/Exception
    //   58	62	68	java/lang/Exception
  }
  
  @NonNull
  public static String getSystemVersion()
  {
    return getSystemVersionName() + "." + getSystemVersionCode();
  }
  
  public static int getSystemVersionCode()
  {
    return systemVersionCode;
  }
  
  @NonNull
  public static String getSystemVersionName()
  {
    return systemVersionName;
  }
  
  public static void init(Context paramContext)
  {
    Properties localProperties = getProperties(paramContext, "mail/app.properties");
    BETA = "true".equals((String)localProperties.get("beta"));
    COVTEST = "true".equals((String)localProperties.get("covtest"));
    LIMITED = "true".equals((String)localProperties.get("limited"));
    LOGCAT = "true".equals((String)localProperties.get("logcat"));
    initSystemVersion(paramContext);
    Log.i("AppConfig", "BETA:" + BETA + ",LIMITED:" + LIMITED + ",LOGCAT:" + LOGCAT);
  }
  
  private static void initSystemVersion(Context paramContext)
  {
    if ((systemVersionName == null) || (systemVersionCode == -1)) {}
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      systemVersionName = paramContext.versionName;
      systemVersionCode = paramContext.versionCode;
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      systemVersionName = "";
      systemVersionCode = -1;
    }
  }
  
  public static boolean isBeta()
  {
    return BETA;
  }
  
  public static boolean isCovtest()
  {
    return COVTEST;
  }
  
  public static boolean isLimited()
  {
    return LIMITED;
  }
  
  public static boolean isLogcat()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.marcos.AppConfig
 * JD-Core Version:    0.7.0.1
 */