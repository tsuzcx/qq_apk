package taiji;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import tmsdk.common.module.pgsdk.IPermissionChecker;

public class bt
{
  static IPermissionChecker a;
  
  public static IPermissionChecker a(Context paramContext, IPermissionChecker paramIPermissionChecker)
  {
    a = paramIPermissionChecker;
    paramIPermissionChecker = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
    if (paramIPermissionChecker.contains("huawei")) {
      return new bv(paramContext);
    }
    if (paramIPermissionChecker.contains("oppo")) {
      return new bx(paramContext);
    }
    if (paramIPermissionChecker.contains("vivo")) {
      return new bz(paramContext);
    }
    if (paramIPermissionChecker.contains("xiaomi")) {
      return new bw(paramContext);
    }
    return new bu(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bt
 * JD-Core Version:    0.7.0.1
 */