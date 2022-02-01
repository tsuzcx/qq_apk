import android.content.SharedPreferences;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import java.io.File;

public class awcc
{
  public static final String TAG;
  public static final String cOW;
  public static final boolean dpM;
  private static boolean dpN;
  private static boolean dpO;
  private static boolean dpP;
  
  static
  {
    boolean bool = true;
    TAG = awcc.class.getSimpleName();
    cOW = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "ENABLE_ANIMATED_WEBP", 1) == 1) {}
    for (;;)
    {
      dpM = bool;
      return;
      bool = false;
    }
  }
  
  private static boolean aMc()
  {
    try
    {
      String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.load(str);
      return true;
    }
    catch (Throwable localThrowable)
    {
      dpN = true;
      QZLog.e(TAG, "load webp so fail", localThrowable);
    }
    return false;
  }
  
  public static boolean aMd()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("animatedWebp.so");
    if (TextUtils.isEmpty(str))
    {
      QZLog.i(TAG, "isWebp SO path not exit");
      return false;
    }
    boolean bool = new File(str).exists();
    QZLog.i(TAG, "isWebp SO path exit : " + bool);
    return bool;
  }
  
  private static boolean isNeedUpdate()
  {
    String str = arym.getPreferences().getString("PREFERENCE_SO_MD5_KEY", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(cOW)) {
      return true;
    }
    return false;
  }
  
  public static boolean isSupportAnimWebp()
  {
    if (!dpO) {
      if ((!dpM) || (dpN) || (!QzoneHardwareRestriction.meetHardwareRestriction(2, 1))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      dpP = bool;
      dpO = true;
      return dpP;
    }
  }
  
  public static boolean loadSo()
  {
    if (!isSupportAnimWebp())
    {
      QZLog.i(TAG, "enable animtedWebp false");
      return false;
    }
    if ((!isNeedUpdate()) && (aMd())) {
      return aMc();
    }
    QzoneModuleManager.getInstance().downloadModule("animatedWebp.so", new awcd());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcc
 * JD-Core Version:    0.7.0.1
 */