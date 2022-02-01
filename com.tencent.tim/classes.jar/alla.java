import android.content.ContentResolver;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class alla
{
  public static String a(TelephonyManager paramTelephonyManager)
  {
    paramTelephonyManager = new Throwable();
    QLog.e("PhoneInfoMonitor", 1, "[getDeviceId] () invoke", paramTelephonyManager);
    allb.h("imei", "getDeviceId", paramTelephonyManager);
    return Pandora.getDeviceID(BaseApplication.getContext());
  }
  
  public static String b(TelephonyManager paramTelephonyManager)
  {
    paramTelephonyManager = new Throwable();
    QLog.e("PhoneInfoMonitor", 1, "[getImei] () invoke", paramTelephonyManager);
    allb.h("imei", "getImei", paramTelephonyManager);
    return Pandora.getImei(BaseApplication.getContext());
  }
  
  public static String c(TelephonyManager paramTelephonyManager)
  {
    Throwable localThrowable = new Throwable();
    QLog.e("PhoneInfoMonitor", 1, "[getLine1Number] invoke", localThrowable);
    allb.h("phone_number", "getLine1Number", localThrowable);
    return paramTelephonyManager.getLine1Number();
  }
  
  public static String d(TelephonyManager paramTelephonyManager)
  {
    Throwable localThrowable = new Throwable();
    QLog.e("PhoneInfoMonitor", 1, "[getSimSerialNumber] invoke", localThrowable);
    allb.h("phone_number", "getSimSerialNumber", localThrowable);
    return paramTelephonyManager.getSimSerialNumber();
  }
  
  public static String e(TelephonyManager paramTelephonyManager)
  {
    paramTelephonyManager = new Throwable();
    QLog.e("PhoneInfoMonitor", 1, "[getSubscriberId] invoke", paramTelephonyManager);
    allb.h("imsi", "getSubscriberId", paramTelephonyManager);
    return Pandora.getImsi(BaseApplication.getContext());
  }
  
  public static String f(TelephonyManager paramTelephonyManager)
  {
    return paramTelephonyManager.getSimOperator();
  }
  
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    if ("android_id".equals(paramString))
    {
      paramContentResolver = new Throwable();
      QLog.e("PhoneInfoMonitor", 1, "[getString] invoke", paramContentResolver);
      allb.Or("getString()AndroidId");
      allb.h("androidId", "getString", paramContentResolver);
      return Pandora.getAndroidID(BaseApplication.getContext());
    }
    return Settings.Secure.getString(paramContentResolver, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alla
 * JD-Core Version:    0.7.0.1
 */