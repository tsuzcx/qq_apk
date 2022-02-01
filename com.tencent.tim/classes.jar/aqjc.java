import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.utils.PerformanceReportUtils.1;
import com.tencent.mobileqq.utils.PerformanceReportUtils.3;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqjc
{
  private static String EMPTY_STRING = "";
  private static long asN = 14400000L;
  private static long asO;
  private static long asP;
  private static long asQ;
  private static long asR;
  private static long asS;
  private static long asT;
  private static long asU;
  private static String ctE = "uiswitchinterval";
  private static String ctF = "uiswitchflag";
  private static String ctG = "fpsinterval";
  private static String ctH = "fpsflag";
  private static String ctI = "actUISwitchC2C";
  private static String ctJ = "actUISwitchGroup";
  private static String ctK = "actUISwitchDiscuss";
  private static String ctL = "actUISwitchQzone";
  private static String ctM = "actUISwitchUserAlbum";
  private static String ctN = "actUISwitchQunAlbum";
  private static String ctO = "actUISwitchUserHome";
  private static String ctP = "actUISwitchPushBannerMyfeed";
  private static String ctQ = "actUISwitchNotificationMyfeed";
  private static String ctR = "actUISwitchMyfeed";
  private static String ctS = "actUISwitchAioPreload";
  static String[] hT = { ctI, ctJ, ctK, ctL, ctM, ctN, ctO };
  
  public static String Cc()
  {
    long l2 = 0L;
    if (ku.cA) {
      l2 = 0L | 0x200;
    }
    long l1 = l2;
    if (BubbleManager.bRK) {
      l1 = l2 | 0x100;
    }
    l2 = l1;
    if (AvatarPendantManager.cVw) {
      l2 = l1 | 0x400;
    }
    return String.valueOf(l2);
  }
  
  public static void a(Intent paramIntent, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramIntent.getLongExtra("key_time_record", -1L);
    if (l2 != -1L)
    {
      paramIntent.removeExtra("key_time_record");
      b(BaseApplicationImpl.getContext(), paramString, paramInt, l1 - l2);
    }
  }
  
  public static void ae(String paramString1, int paramInt, String paramString2)
  {
    new aqjd(paramString1, paramInt, paramString2).execute(new Void[0]);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    ThreadManager.post(new PerformanceReportUtils.1(paramInt, paramLong, paramString), 8, null, false);
  }
  
  public static void bm(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS saveCompleteTime ：tag:" + paramString + ",time:" + paramLong);
    }
    if ("actFPSAIO".equals(paramString)) {
      asO = paramLong;
    }
    do
    {
      return;
      if ("actFPSRecent".equals(paramString))
      {
        asP = paramLong;
        return;
      }
      if ("actFPSFriend".equals(paramString))
      {
        asQ = paramLong;
        return;
      }
      if ("actFPSQZoneFriendFeed".equals(paramString))
      {
        asR = paramLong;
        return;
      }
      if ("actFPSQZoneMyFeed".equals(paramString))
      {
        asS = paramLong;
        return;
      }
      if ("actFPSQZoneUserHome".equals(paramString))
      {
        asT = paramLong;
        return;
      }
    } while (!"actFPSQZoneMoodList".equals(paramString));
    asU = paramLong;
  }
  
  public static void edW()
  {
    ku.cA = false;
    AvatarPendantManager.cVw = false;
    BubbleManager.bRK = false;
    adxn.a().clearCache();
    ThreadManager.executeOnSubThread(new PerformanceReportUtils.3());
  }
  
  private static SharedPreferences getSp()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("PerformanceReportUtils", i);
    }
  }
  
  private static boolean ry(String paramString)
  {
    long l;
    if ("actFPSAIO".equals(paramString)) {
      l = asO;
    }
    for (;;)
    {
      if (l == 0L) {}
      while ((float)(SystemClock.uptimeMillis() - l) / 1000.0F >= 10.0F)
      {
        return false;
        if ("actFPSRecent".equals(paramString))
        {
          l = asP;
          break;
        }
        if (!"actFPSFriend".equals(paramString)) {
          break label72;
        }
        l = asQ;
        break;
      }
      return true;
      label72:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjc
 * JD-Core Version:    0.7.0.1
 */