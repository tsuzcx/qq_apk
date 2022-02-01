import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager.1;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager.2;
import com.tencent.mobileqq.bgprobe.BackgroundService;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class adwp
{
  private static final long VG = TimeUnit.DAYS.toMillis(1L);
  private static boolean bRw;
  private static boolean bRx;
  private static boolean bRy;
  private long VH = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", 0L);
  private Context mContext = BaseApplicationImpl.context;
  
  private adwp()
  {
    if (new Random(System.currentTimeMillis()).nextInt(100000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      bRy = bool;
      return;
    }
  }
  
  private static int BV()
  {
    Object localObject = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.tencent.mobileqq", 128);
      if (localObject != null)
      {
        int i = ((ApplicationInfo)localObject).targetSdkVersion;
        return i;
      }
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static adwp a()
  {
    return adwp.a.b();
  }
  
  private boolean afI()
  {
    if (System.currentTimeMillis() - this.VH > VG) {}
    for (int i = 1; (afJ()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  private static boolean afJ()
  {
    int i;
    if (BV() >= 26)
    {
      i = 1;
      if (Build.VERSION.SDK_INT < 24) {
        break label35;
      }
    }
    label35:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label40;
      }
      return true;
      i = 0;
      break;
    }
    label40:
    return false;
  }
  
  private void cUR()
  {
    try
    {
      if (!bRw)
      {
        Intent localIntent = new Intent(this.mContext, BackgroundService.class);
        this.mContext.startService(localIntent);
        this.VH = System.currentTimeMillis();
        bRw = true;
        PreferenceManager.getDefaultSharedPreferences(this.mContext).edit().putLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", this.VH).apply();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      annt.e(new BackgroundException("startProbeService failed"));
    }
  }
  
  private void cUS()
  {
    try
    {
      if (bRw)
      {
        Intent localIntent = new Intent(this.mContext, BackgroundService.class);
        this.mContext.stopService(localIntent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BackgroundProbeManager", 2, "stopProbeService: failed. ", localThrowable);
    }
  }
  
  public static void jdMethod_do(Intent paramIntent)
  {
    if (new Random(System.currentTimeMillis()).nextInt(400) == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((bRy) && (afJ()) && (!bRx) && (i != 0) && (paramIntent.getComponent() == null))
      {
        BackgroundException localBackgroundException = new BackgroundException("Implicit Broadcast");
        annt.e(localBackgroundException, "intent: " + paramIntent.toString());
        bRx = true;
        if (QLog.isColorLevel()) {
          QLog.i("BackgroundProbeManager", 2, "reportImplicitBroadcast: invoked.  exception: " + localBackgroundException);
        }
      }
      return;
    }
  }
  
  public static void onRunningBackground()
  {
    adwp localadwp = a();
    BackgroundProbeManager.1 local1 = new BackgroundProbeManager.1(localadwp);
    BackgroundProbeManager.2 local2 = new BackgroundProbeManager.2(localadwp);
    boolean bool = localadwp.afI();
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundProbeManager", 2, "onRunningBackground: invoked.  probeEnabled: " + bool);
    }
    if (bool) {
      aoyb.j(local1, 180000L);
    }
    aoyb.j(local2, 181000L);
  }
  
  static class a
  {
    private static final adwp b = new adwp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     adwp
 * JD-Core Version:    0.7.0.1
 */