import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;

public class tza
{
  private static int bDf = -1;
  private static String deviceId = "";
  
  public static String a(Application paramApplication)
  {
    if (!TextUtils.isEmpty(deviceId)) {
      return deviceId;
    }
    String str1 = "";
    Context localContext = paramApplication.getApplicationContext();
    Object localObject = str1;
    if (a(paramApplication))
    {
      paramApplication = (TelephonyManager)localContext.getSystemService("phone");
      String str2 = alla.a(paramApplication);
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        localObject = "" + str2;
      }
      str1 = alla.e(paramApplication);
      if (TextUtils.isEmpty(str1)) {
        break label170;
      }
      paramApplication = (String)localObject + str1;
    }
    for (;;)
    {
      localObject = paramApplication;
      if (TextUtils.isEmpty(paramApplication))
      {
        localObject = paramApplication;
        if (Build.VERSION.SDK_INT >= 23) {
          localObject = auri.getSerial();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramApplication = (Application)localObject;
        if (!((String)localObject).startsWith("012345678912345")) {}
      }
      else
      {
        paramApplication = alla.getString(localContext.getContentResolver(), "android_id");
      }
      deviceId = MD5.toMD5(paramApplication);
      return deviceId;
      label170:
      str1 = alla.f(paramApplication);
      paramApplication = (Application)localObject;
      if (!TextUtils.isEmpty(str1)) {
        paramApplication = (String)localObject + str1;
      }
    }
  }
  
  private static boolean a(Application paramApplication)
  {
    boolean bool = true;
    if (bDf == -1)
    {
      bool = a(paramApplication, "android.permission.READ_PHONE_STATE");
      if (bool) {
        bDf = 1;
      }
    }
    while (bDf > 0) {
      for (;;)
      {
        return bool;
        bDf = 0;
      }
    }
    return false;
  }
  
  private static boolean a(Application paramApplication, String paramString)
  {
    if (paramApplication == null) {}
    PackageManager localPackageManager;
    do
    {
      return false;
      localPackageManager = paramApplication.getPackageManager();
    } while ((localPackageManager == null) || (localPackageManager.checkPermission(paramString, paramApplication.getPackageName()) != 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tza
 * JD-Core Version:    0.7.0.1
 */