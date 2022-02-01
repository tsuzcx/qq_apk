import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

@TargetApi(16)
public class txn
{
  private static long ES;
  private static txn a;
  
  private static boolean Ov()
  {
    return 2 == BaseApplicationImpl.sProcessId;
  }
  
  @NotNull
  public static HashMap<String, String> a(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    awiy.a().a(paramString, paramLong2, paramArrayOfLong, paramLong1);
    if (QLog.isColorLevel()) {
      Log.d("AutoMonitor.DropFrame", "tag = " + paramString + ", dropCount = " + paramLong2 + ", " + Arrays.toString(paramArrayOfLong) + ", totalMs = " + paramLong1);
    }
    if (Ov()) {}
    double d1 = paramArrayOfLong[4];
    double d2 = paramArrayOfLong[5];
    double d3 = paramArrayOfLong[0];
    double d4 = paramArrayOfLong[1];
    double d5 = paramArrayOfLong[2];
    double d6 = paramArrayOfLong[3];
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("dropCount", String.valueOf(paramLong2));
    localHashMap.put("totalMs", String.valueOf(paramLong1));
    localHashMap.put("scene", paramString);
    localHashMap.put("dropTimes", Arrays.toString(paramArrayOfLong));
    localHashMap.put("themeId", QQAppInterface.getCurrentThemeId());
    localHashMap.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
    String str1;
    String str2;
    String str3;
    if (ES > 0L)
    {
      paramLong1 = SystemClock.uptimeMillis() - ES;
      localHashMap.put("intervalAfterSyncMsg", String.valueOf(paramLong1));
      localHashMap.put("hcState", String.valueOf(tzc.a().getState()));
      localHashMap.put("dropFenzi", String.valueOf(266.72000000000003D * d2 + 200.04000000000002D * d1));
      localHashMap.put("dropFenzi2", String.valueOf(16.699999999999999D * d3 + 25.049999999999997D * d4 + 50.099999999999994D * d5 + 100.19999999999999D * d6));
      if (anmo.cIF)
      {
        paramArrayOfLong = "-1";
        str1 = "-1";
        str2 = "-1";
        str3 = "-1";
        paramLong1 = System.currentTimeMillis();
        if (AutomatorFinish.Rb != -1L) {
          break label507;
        }
      }
    }
    label507:
    for (paramString = "-1";; paramString = String.valueOf(paramLong1 - AutomatorFinish.Rb))
    {
      if (anmo.amm != 0L) {
        paramArrayOfLong = String.valueOf(paramLong1 - anmo.amm);
      }
      if (anmo.aml != 0L) {
        str1 = String.valueOf(paramLong1 - anmo.aml);
      }
      if (anmo.amo != 0L) {
        str2 = String.valueOf(paramLong1 - anmo.amo);
      }
      if (anmo.amn != 0L) {
        str3 = String.valueOf(paramLong1 - anmo.amn);
      }
      localHashMap.put("perfConfigReportValue", String.valueOf(anmo.dKf));
      localHashMap.put("qZoneInterval", paramArrayOfLong);
      localHashMap.put("miniInterval", str1);
      localHashMap.put("troopListInterval", str2);
      localHashMap.put("preDownloadInterval", str3);
      localHashMap.put("automatorFinishtime", paramString);
      UnifiedMonitor.a().addEvent(9, null, 0, 0, localHashMap);
      return localHashMap;
      paramLong1 = -1L;
      break;
    }
  }
  
  public static txn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new txn();
      }
      return a;
    }
    finally {}
  }
  
  public static void bEP()
  {
    ES = SystemClock.uptimeMillis();
  }
  
  public void startMonitorScene(String paramString)
  {
    QAPM.beginScene(paramString, QAPM.ModeDropFrame);
    if (paramString.equals("qzone_homepage")) {
      tzc.a().a(0, 1, 1, 0, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
    }
    while (!paramString.equals("list_photo")) {
      return;
    }
    tzc.a().a(0, 1, 1, 0, 1500, 702, 32L, Process.myTid(), "photoList", false);
  }
  
  public void stopMonitorScene(String paramString, boolean paramBoolean)
  {
    QAPM.endScene(paramString, QAPM.ModeDropFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */