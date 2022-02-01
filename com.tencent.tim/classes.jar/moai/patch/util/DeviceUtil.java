package moai.patch.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import moai.patch.log.PatchLog;
import moai.patch.sharedpref.SharedPrefUtil;

public class DeviceUtil
{
  public static String getRomCurrentFingerprint()
  {
    return "api_" + Build.VERSION.SDK_INT + "_" + Build.FINGERPRINT;
  }
  
  public static boolean isPatchFingerPrint4x(Context paramContext)
  {
    try
    {
      paramContext = SharedPrefUtil.getPatchRomFingerprint(paramContext);
      if (paramContext.equals("")) {
        return false;
      }
      paramContext = paramContext.split("_", 3);
      if (paramContext.length >= 3)
      {
        int i = Integer.parseInt(paramContext[1]);
        if (i <= 19) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      PatchLog.d("isPatchFingerPrint4x err:" + paramContext.toString());
    }
    return false;
  }
  
  public static boolean isSystemOTA(Context paramContext)
  {
    paramContext = SharedPrefUtil.getPatchRomFingerprint(paramContext);
    String str = getRomCurrentFingerprint();
    if ((paramContext.equals("")) || (str == null) || (str.equals(""))) {}
    while (paramContext.equals(str)) {
      return false;
    }
    PatchLog.w(2025, "fingerprint changed:" + paramContext + ",current:" + str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */