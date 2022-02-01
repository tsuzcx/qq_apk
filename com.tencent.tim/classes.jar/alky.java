import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class alky
{
  private static List<CellInfo> Fb;
  private static CellLocation jdField_a_of_type_AndroidTelephonyCellLocation;
  private static ServiceState jdField_a_of_type_AndroidTelephonyServiceState;
  private static Location b;
  
  @SuppressLint({"MissingPermission"})
  public static Location a(LocationManager paramLocationManager, String paramString)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.getLastKnownLocation", "getLastKnownLocation(Background)", localThrowable);
      return b;
    }
    QLog.e("LocationMonitor", 1, "[getLastKnownLocation] invoke, ", localThrowable);
    allb.h("foreground_location", "getLastKnownLocation", localThrowable);
    b = paramLocationManager.getLastKnownLocation(paramString);
    return b;
  }
  
  public static CellLocation a(TelephonyManager paramTelephonyManager)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.getCellLocation", "getCellLocation(Background)", localThrowable);
      return jdField_a_of_type_AndroidTelephonyCellLocation;
    }
    QLog.e("LocationMonitor", 1, "[getCellLocation] invoke", localThrowable);
    allb.h("foreground_location", "getCellLocation", localThrowable);
    jdField_a_of_type_AndroidTelephonyCellLocation = paramTelephonyManager.getCellLocation();
    return jdField_a_of_type_AndroidTelephonyCellLocation;
  }
  
  public static ServiceState a(TelephonyManager paramTelephonyManager)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.getServiceState", "getServiceState(Background)", localThrowable);
      return jdField_a_of_type_AndroidTelephonyServiceState;
    }
    QLog.e("LocationMonitor", 1, "[getServiceState] invoke", localThrowable);
    allb.h("foreground_location", "getServiceState", localThrowable);
    jdField_a_of_type_AndroidTelephonyServiceState = paramTelephonyManager.getServiceState();
    return jdField_a_of_type_AndroidTelephonyServiceState;
  }
  
  public static List<CellInfo> a(TelephonyManager paramTelephonyManager)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.getAllCellInfo", "getAllCellInfo(Background)", localThrowable);
      return Fb;
    }
    QLog.e("LocationMonitor", 1, "[getAllCellInfo] invoke", localThrowable);
    allb.h("foreground_location", "getAllCellInfo", localThrowable);
    Fb = paramTelephonyManager.getAllCellInfo();
    return Fb;
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(LocationManager paramLocationManager, String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.requestLocationUpdates(SLFL)", "requestLocationUpdates(SLFL)(Background)", localThrowable);
      return;
    }
    QLog.e("LocationMonitor", 1, "[requestLocationUpdates] (SLFL) invoke", localThrowable);
    allb.h("foreground_location", "requestLocationUpdates(SLFL)", localThrowable);
    paramLocationManager.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(LocationManager paramLocationManager, String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
  {
    Throwable localThrowable = new Throwable();
    if (!isAppOnForeground())
    {
      g("LocationMonitor.requestLocationUpdates(SLFLL)", "requestLocationUpdates(SLFLL)(Background)", localThrowable);
      return;
    }
    QLog.e("LocationMonitor", 1, "[requestLocationUpdates] (SLFLL) invoke", localThrowable);
    allb.h("foreground_location", "requestLocationUpdates(SLFLL)", localThrowable);
    paramLocationManager.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
  }
  
  public static void g(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d("LocationMonitor", 1, "[background request]" + paramString1, paramThrowable);
    allb.j("background_location", paramString2, paramThrowable);
  }
  
  public static boolean isAppOnForeground()
  {
    Object localObject = (ActivityManager)MobileQQ.getMobileQQ().getBaseContext().getSystemService("activity");
    String str = MobileQQ.getMobileQQ().getBaseContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith(str))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alky
 * JD-Core Version:    0.7.0.1
 */