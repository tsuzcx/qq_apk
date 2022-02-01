package com.tencent.qqmail.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollectorImpl;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import com.tencent.qqmail.utilities.patch.QMPatchManagerService;
import com.tencent.qqmail.utilities.receiver.QMIPCBroadcastManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import moai.core.watcher.Watchers;

public class PermissionUtils
{
  public static final int APP_DETAIL_REQ_CODE = 100;
  public static String[] Required_Permission = { "android.permission.WRITE_EXTERNAL_STORAGE" };
  private static final String TAG = "PermissionUtils";
  private static int lastPermissionState = -1;
  
  @TargetApi(23)
  public static boolean checkPermissions(Context paramContext, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    for (;;)
    {
      return true;
      if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
      {
        QMLog.log(5, "PermissionUtils", "Illeage Param " + Arrays.toString(paramArrayOfString));
        return true;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (paramContext.checkSelfPermission(str) != 0)
        {
          QMLog.log(5, "PermissionUtils", "Permission[%s] is not granted", new Object[] { str });
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static void handlePermissionChange()
  {
    QMOssClient.getInstance().updatePath();
    DataCollectorImpl.updatePath();
    QMPatchManagerService.updatePatchDownloadPath();
    ((PermissionChangedWatcher)Watchers.of(PermissionChangedWatcher.class)).onPermssionChanged(Required_Permission);
  }
  
  public static boolean hasNotificationPostPermission()
  {
    return NotificationManagerCompat.from(QMApplicationContext.sharedInstance()).areNotificationsEnabled();
  }
  
  public static boolean hasNotificationVolumePermissoin()
  {
    return hasPermission("OP_AUDIO_NOTIFICATION_VOLUME");
  }
  
  private static boolean hasPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        AppOpsManager localAppOpsManager = (AppOpsManager)QMApplicationContext.sharedInstance().getSystemService("appops");
        Method localMethod = AppOpsManager.class.getDeclaredMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        localMethod.setAccessible(true);
        paramString = AppOpsManager.class.getDeclaredField(paramString);
        paramString.setAccessible(true);
        int i = ((Integer)localMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)paramString.get(null)).intValue()), Integer.valueOf(Process.myUid()), QMApplicationContext.sharedInstance().getPackageName() })).intValue();
        return i == 0;
      }
      catch (Exception paramString)
      {
        QMLog.log(5, "PermissionUtils", "detect permission failed", paramString);
      }
    }
    return true;
  }
  
  public static boolean hasPermissionVibrate()
  {
    return hasPermission("OP_VIBRATE");
  }
  
  public static boolean hasReadPhoneStatePermission(Context paramContext)
  {
    return checkPermissions(paramContext, new String[] { "android.permission.READ_PHONE_STATE" });
  }
  
  public static boolean hasRequiredPermission(Context paramContext)
  {
    return checkPermissions(paramContext, Required_Permission);
  }
  
  public static boolean hasWriteExternalStoragePermission(Context paramContext)
  {
    return checkPermissions(paramContext, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
  }
  
  public static boolean isReqPermChange(Context paramContext)
  {
    int i = 1;
    boolean bool3 = hasRequiredPermission(paramContext);
    if ((bool3) && (lastPermissionState == 1)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (lastPermissionState == 0) {
          bool2 = false;
        }
      }
      if (bool3) {}
      for (;;)
      {
        lastPermissionState = i;
        Log.i("PermissionUtils", "isReqPermChange = " + bool2);
        return bool2;
        i = 0;
      }
    }
  }
  
  public static void launchAppDetailPageForResult(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", paramActivity.getPackageName(), null));
    paramActivity.startActivityForResult(localIntent, 100);
  }
  
  public static void notifyPermissionChange() {}
  
  public static void permissionWarn(Activity paramActivity, int paramInt, CancelPermissionWarinCallback paramCancelPermissionWarinCallback)
  {
    if (paramActivity == null) {
      throw new IllegalArgumentException("The argument 'activity' should not be null");
    }
    paramActivity = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramActivity).setTitle(2131718911)).setMessage(paramInt).addAction(2131691246, new PermissionUtils.2(paramCancelPermissionWarinCallback))).addAction(0, 2131719634, 0, new PermissionUtils.1(paramActivity))).create();
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    boolean bool = ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, paramString);
    QMLog.log(4, "PermissionUtils", "shouldShowRequestPermissionRationale = " + bool);
    return bool;
  }
  
  public static abstract interface CancelPermissionWarinCallback
  {
    public abstract void cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */