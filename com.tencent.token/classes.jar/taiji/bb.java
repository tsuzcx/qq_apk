package taiji;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tmsdk.common.module.pgsdk.IPermissionChecker;

public class bb
  implements IPermissionChecker
{
  protected Context a;
  protected AppOpsManager b;
  protected Method c;
  protected int d;
  protected int e;
  
  bb(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.a = paramContext;
    this.b = ((AppOpsManager)paramContext.getSystemService("appops"));
    try
    {
      this.c = AppOpsManager.class.getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      paramContext = AppOpsManager.class.getField("MODE_ALLOWED");
      Field localField = AppOpsManager.class.getField("MODE_DEFAULT");
      paramContext.setAccessible(true);
      localField.setAccessible(true);
      this.d = paramContext.getInt(AppOpsManager.class);
      this.e = localField.getInt(AppOpsManager.class);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private int a()
  {
    return 2;
  }
  
  private int a(String paramString)
  {
    Context localContext;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localContext = this.a;
      if (localContext == null) {
        return 0;
      }
    }
    try
    {
      int i = localContext.checkCallingOrSelfPermission(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return 0;
    return 0;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if ((this.a != null) && (this.b != null))
    {
      if (this.c == null) {
        return 0;
      }
      try
      {
        paramString1 = AppOpsManager.class.getField(paramString1);
        if (paramString1 != null)
        {
          paramString1.setAccessible(true);
          int i = paramString1.getInt(AppOpsManager.class);
          i = ((Integer)this.c.invoke(this.b, new Object[] { Integer.valueOf(i), Integer.valueOf(Process.myUid()), this.a.getPackageName() })).intValue();
          if ((i == this.e) && (!TextUtils.isEmpty(paramString2))) {
            return this.a.checkCallingOrSelfPermission(paramString2);
          }
          int j = this.d;
          if (i != j) {
            return -1;
          }
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return 0;
  }
  
  private int b()
  {
    return 2;
  }
  
  private int c()
  {
    if (a("OP_SYSTEM_ALERT_WINDOW", "android.permission.SYSTEM_ALERT_WINDOW") == -1)
    {
      Log.i("BasePermissionChecker", "Float window state disabled by appops check");
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if (!Settings.canDrawOverlays(this.a))
      {
        Log.i("BasePermissionChecker", "Float window state disabled by api check");
        return -1;
      }
    }
    catch (Throwable localThrowable)
    {
      label50:
      break label50;
    }
    return 0;
  }
  
  private int d()
  {
    return a("OP_GET_USAGE_STATS", "android.permission.PACKAGE_USAGE_STATS");
  }
  
  private int e()
  {
    if (a("OP_POST_NOTIFICATION", "") == -1) {
      return -1;
    }
    NotificationManager localNotificationManager;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localNotificationManager = (NotificationManager)this.a.getSystemService("notification");
      if (localNotificationManager == null) {}
    }
    try
    {
      boolean bool = localNotificationManager.areNotificationsEnabled();
      if (!bool) {
        return -1;
      }
    }
    catch (Throwable localThrowable)
    {
      label50:
      break label50;
    }
    return 0;
  }
  
  private int f()
  {
    String str = this.a.getPackageName();
    try
    {
      Object localObject = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(":");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          ComponentName localComponentName = ComponentName.unflattenFromString(localObject[i]);
          if (localComponentName != null)
          {
            boolean bool = TextUtils.equals(str, localComponentName.getPackageName());
            if (bool) {
              return 0;
            }
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private int g()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.System.canWrite(this.a))) {
      return -1;
    }
    return 0;
  }
  
  private int h()
  {
    return 2;
  }
  
  private int i()
  {
    IPermissionChecker localIPermissionChecker = ba.a;
    if (localIPermissionChecker != null) {
      return localIPermissionChecker.checkPermission(37);
    }
    return 2;
  }
  
  private int j()
  {
    return 2;
  }
  
  private int k()
  {
    return 2;
  }
  
  private int l()
  {
    return 2;
  }
  
  private int m()
  {
    return 2;
  }
  
  private int n()
  {
    return 2;
  }
  
  private int o()
  {
    return a("OP_GET_USAGE_STATS", "android.permission.PACKAGE_USAGE_STATS");
  }
  
  private int p()
  {
    Log.i("BasePermissionChecker", "checkDefaultPhoneService");
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return 0;
      }
      String str = ((Context)localObject).getPackageName();
      localObject = (TelecomManager)this.a.getSystemService("telecom");
      if (localObject != null) {
        localObject = ((TelecomManager)localObject).getDefaultDialerPackage();
      } else {
        localObject = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("packageName:");
      localStringBuilder.append(str);
      localStringBuilder.append(", dialerPkg:");
      localStringBuilder.append((String)localObject);
      Log.i("BasePermissionChecker", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(str)) && (!str.equals(localObject))) {
        return -1;
      }
    }
    return 0;
  }
  
  private int q()
  {
    return 2;
  }
  
  private int r()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return 0;
    }
    int j = -1;
    try
    {
      int i = Settings.Secure.getInt(this.a.getContentResolver(), "location_mode");
      if (i != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        j = 0;
      }
      return j;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int checkPermission(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    String str;
    switch (paramInt)
    {
    case 7: 
    case 15: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 42: 
    case 44: 
    case 48: 
    default: 
      return 0;
    case 49: 
      return r();
    case 47: 
      return q();
    case 46: 
      return p();
    case 45: 
      return o();
    case 43: 
      return n();
    case 41: 
      return m();
    case 40: 
      return l();
    case 39: 
      return k();
    case 38: 
      return j();
    case 37: 
      return i();
    case 36: 
      return h();
    case 35: 
      str = "android.permission.BLUETOOTH";
    }
    for (;;)
    {
      return a(str);
      str = "android.permission.CHANGE_WIFI_STATE";
      continue;
      str = "android.permission.CHANGE_NETWORK_STATE";
      continue;
      str = "android.permission.GET_ACCOUNTS";
      continue;
      return g();
      str = "android.permission.RECORD_AUDIO";
      continue;
      str = "android.permission.CAMERA";
      continue;
      str = "android.permission.WRITE_CALENDAR";
      continue;
      str = "android.permission.READ_CALENDAR";
      continue;
      str = "com.android.launcher.permission.INSTALL_SHORTCUT";
      continue;
      return f();
      str = "android.permission.ACCESS_FINE_LOCATION";
      continue;
      str = "android.permission.WRITE_CONTACTS";
      continue;
      str = "android.permission.READ_CONTACTS";
      continue;
      str = "android.permission.SEND_SMS";
      continue;
      str = "android.permission.READ_SMS";
      continue;
      str = "android.permission.WRITE_CALL_LOG";
      continue;
      str = "android.permission.READ_CALL_LOG";
      continue;
      str = "android.permission.CALL_PHONE";
      continue;
      str = "android.permission.PROCESS_OUTGOING_CALLS";
      continue;
      return e();
      return d();
      return c();
      return b();
      return a();
      str = "android.permission.WRITE_EXTERNAL_STORAGE";
      continue;
      str = "android.permission.READ_PHONE_STATE";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bb
 * JD-Core Version:    0.7.0.1
 */