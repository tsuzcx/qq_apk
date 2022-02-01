package taiji;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import tmsdk.common.module.pgsdk.IPermissionChecker;

public class ba
{
  static IPermissionChecker a;
  
  public static IPermissionChecker a(Context paramContext, IPermissionChecker paramIPermissionChecker)
  {
    a = paramIPermissionChecker;
    paramIPermissionChecker = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
    if (paramIPermissionChecker.contains("huawei")) {
      return new bc(paramContext);
    }
    if (paramIPermissionChecker.contains("oppo")) {
      return new be(paramContext);
    }
    if (paramIPermissionChecker.contains("vivo")) {
      return new bf(paramContext);
    }
    if (paramIPermissionChecker.contains("xiaomi")) {
      return new bd(paramContext);
    }
    return new bb(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ba
 * JD-Core Version:    0.7.0.1
 */