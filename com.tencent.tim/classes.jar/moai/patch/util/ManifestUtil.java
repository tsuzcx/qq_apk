package moai.patch.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class ManifestUtil
{
  private static Bundle sMetaData;
  
  public static String exceptionHandlerClassName(Context paramContext)
  {
    return get(paramContext, "PATCH_EXCEPTION_HANDLER");
  }
  
  /* Error */
  private static String get(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 23	moai/patch/util/ManifestUtil:sMetaData	Landroid/os/Bundle;
    //   3: ifnonnull +37 -> 40
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 23	moai/patch/util/ManifestUtil:sMetaData	Landroid/os/Bundle;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +23 -> 37
    //   17: aload_0
    //   18: invokevirtual 29	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   21: aload_0
    //   22: invokevirtual 33	android/content/Context:getPackageName	()Ljava/lang/String;
    //   25: sipush 128
    //   28: invokevirtual 39	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   31: getfield 44	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   34: putstatic 23	moai/patch/util/ManifestUtil:sMetaData	Landroid/os/Bundle;
    //   37: ldc 2
    //   39: monitorexit
    //   40: getstatic 23	moai/patch/util/ManifestUtil:sMetaData	Landroid/os/Bundle;
    //   43: ifnull +19 -> 62
    //   46: getstatic 23	moai/patch/util/ManifestUtil:sMetaData	Landroid/os/Bundle;
    //   49: aload_1
    //   50: ldc 46
    //   52: invokevirtual 52	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: areturn
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: ldc 46
    //   64: areturn
    //   65: astore_0
    //   66: goto -29 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramContext	Context
    //   0	69	1	paramString	String
    //   12	2	2	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   9	13	56	finally
    //   17	37	56	finally
    //   37	40	56	finally
    //   57	60	56	finally
    //   17	37	65	java/lang/Exception
  }
  
  public static String[] getFailProtectedProcess(Context paramContext)
  {
    return get(paramContext, "PATCH_FAIL_PROTECT").split(",");
  }
  
  public static boolean isFailProtected(Context paramContext, String paramString)
  {
    return isSpecifyiedProcess(paramString, getFailProtectedProcess(paramContext));
  }
  
  private static boolean isSpecifyiedProcess(String paramString, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return false;
    }
    int j = paramVarArgs.length;
    int i = 0;
    label23:
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        break label48;
      }
    }
    label48:
    while (!paramString.endsWith(str))
    {
      i += 1;
      break label23;
      break;
    }
    return true;
  }
  
  public static boolean mainDexOnly(Context paramContext, String paramString)
  {
    return isSpecifyiedProcess(paramString, get(paramContext, "PATCH_NO_MULTI_DEX").split(","));
  }
  
  public static String quickLaunchClassName(Context paramContext)
  {
    return get(paramContext, "PATCH_QUICK_LAUNCH");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.ManifestUtil
 * JD-Core Version:    0.7.0.1
 */