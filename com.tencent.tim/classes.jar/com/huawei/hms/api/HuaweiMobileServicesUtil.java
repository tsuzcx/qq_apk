package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;

public abstract class HuaweiMobileServicesUtil
{
  public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static String getErrorString(int paramInt)
  {
    return HuaweiApiAvailability.getInstance().getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return "";
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.huawei.hwid", 2);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.huawei.hwid");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext)
  {
    return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramContext);
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16) {
      return 21;
    }
    paramContext = new PackageManagerHelper(paramContext);
    PackageManagerHelper.PackageStates localPackageStates = paramContext.getPackageStates("com.huawei.hwid");
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates)) {
      return 1;
    }
    if (PackageManagerHelper.PackageStates.DISABLED.equals(localPackageStates)) {
      return 3;
    }
    if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(paramContext.getPackageSignature("com.huawei.hwid"))) {
      return 9;
    }
    int i = paramContext.getPackageVersionCode("com.huawei.hwid");
    HMSLog.i("HuaweiMobileServicesUtil", "connect versionCode:" + i);
    if (i < paramInt) {
      return 2;
    }
    return 0;
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    return HuaweiApiAvailability.getInstance().isUserResolvableError(paramInt);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramFragment, paramInt2, paramOnCancelListener);
  }
  
  public static void setApplication(Application paramApplication)
  {
    ActivityMgr.INST.init(paramApplication);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    HuaweiApiAvailability.getInstance().showErrorNotification(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiMobileServicesUtil
 * JD-Core Version:    0.7.0.1
 */