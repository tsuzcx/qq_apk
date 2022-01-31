package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class AppOpsManagerCompat
{
  public static final int MODE_ALLOWED = 0;
  public static final int MODE_DEFAULT = 3;
  public static final int MODE_ERRORED = 2;
  public static final int MODE_IGNORED = 1;
  
  public static int noteOp(@NonNull Context paramContext, @NonNull String paramString1, int paramInt, @NonNull String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AppOpsManager)paramContext.getSystemService("appops")).noteOp(paramString1, paramInt, paramString2);
    }
    return 1;
  }
  
  public static int noteOpNoThrow(@NonNull Context paramContext, @NonNull String paramString1, int paramInt, @NonNull String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((AppOpsManager)paramContext.getSystemService("appops")).noteOpNoThrow(paramString1, paramInt, paramString2);
    }
    return 1;
  }
  
  public static int noteProxyOp(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
    }
    return 1;
  }
  
  public static int noteProxyOpNoThrow(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, paramString2);
    }
    return 1;
  }
  
  @Nullable
  public static String permissionToOp(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return AppOpsManager.permissionToOp(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.AppOpsManagerCompat
 * JD-Core Version:    0.7.0.1
 */