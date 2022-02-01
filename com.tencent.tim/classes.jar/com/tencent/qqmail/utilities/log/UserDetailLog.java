package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;
import java.util.Locale;

public class UserDetailLog
{
  public static final String TAG = "UserDetailLog";
  
  private static void logFingerPrint()
  {
    Log.i("UserDetailLog", "MeizuFingerprintManager logFingerPrint");
    if (FingerprintFactory.createInstance().isHarewareDetected())
    {
      DataCollector.logEvent("Event_Fingerprint_supported_device");
      if (FingerprintFactory.createInstance().isEnrolled()) {
        DataCollector.logEvent("Event_Fingerprint_supported_and_set_device");
      }
    }
  }
  
  private static void logLanguageAndCountry()
  {
    Object localObject = Locale.getDefault();
    String str = ((Locale)localObject).getLanguage();
    localObject = ((Locale)localObject).getCountry();
    QMLog.log(4, "UserDetailLog", "language = " + str);
    QMLog.log(4, "UserDetailLog", "country = " + (String)localObject);
    if ((str.toLowerCase().equals("zh")) || ((!str.toLowerCase().equals("en")) || (!((String)localObject).toLowerCase().equals("cn")))) {}
  }
  
  private static void logPullDownAds()
  {
    AdvertiseManager.getInstance().logDetailAboutAds();
  }
  
  public static void logUserDetail() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.UserDetailLog
 * JD-Core Version:    0.7.0.1
 */