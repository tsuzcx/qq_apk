import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ahgd
{
  public static void JY(String paramString)
  {
    if (needReport())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pagePath", paramString);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_pv", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  private static long a(String paramString, Map<String, Integer> paramMap1, Map<String, Integer> paramMap2)
  {
    if ((paramMap1 == null) || (paramMap2 == null)) {
      return 0L;
    }
    if ((!paramMap1.containsKey(paramString)) || (!paramMap2.containsKey(paramString)))
    {
      QLog.d("QFlutter.Reporter", 1, String.format("%s not contains", new Object[] { paramString }));
      return 0L;
    }
    long l = ((Integer)paramMap1.get(paramString)).intValue();
    return ((Integer)paramMap2.get(paramString)).intValue() - l;
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HashMap localHashMap;
    if (needReport())
    {
      localHashMap = new HashMap();
      localHashMap.put("errCode", String.valueOf(paramInt));
      localHashMap.put("launchCost", String.valueOf(paramLong1));
      localHashMap.put("installCost", String.valueOf(paramLong2));
      localHashMap.put("loadAssetCost", String.valueOf(paramLong3));
      localHashMap.put("loadEngineCost", String.valueOf(paramLong4));
      if (!paramBoolean1) {
        break label276;
      }
      str = "1";
      localHashMap.put("isPreloadProcess", str);
      if (!paramBoolean2) {
        break label283;
      }
      str = "1";
      label105:
      localHashMap.put("isLocalEngineExist", str);
      if (!paramBoolean3) {
        break label290;
      }
      str = "1";
      label124:
      localHashMap.put("isLocalAppExist", str);
      if ((!paramBoolean3) && (!paramBoolean2)) {
        break label297;
      }
    }
    label276:
    label283:
    label290:
    label297:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isLocalExist", str);
      localHashMap.put("flutterUin", getUin());
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_launch_result_v2", true, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.Reporter", 2, String.format("reportLaunchResult, errCode: %s, launchCost: %s, installCost: %s,loadAssetCost: %s, loadEngineCost: %s, isPreloadProcess: %s, isLocalEngineExist: %s, isLocalAppExist: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
      }
      return;
      str = "0";
      break;
      str = "0";
      break label105;
      str = "0";
      break label124;
    }
  }
  
  public static void a(String paramString, int paramInt, double paramDouble)
  {
    if (needReport())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pagePath", paramString);
      localHashMap.put("fps", String.valueOf(paramInt));
      localHashMap.put("dropRate", String.valueOf(paramDouble));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_fps", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public static void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!needReport()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean1)
    {
      str = "1";
      label24:
      localHashMap.put("errCode", str);
      localHashMap.put("cost", String.valueOf(paramLong));
      if (!paramBoolean2) {
        break label140;
      }
      str = "1";
      label54:
      localHashMap.put("isLocalEngineExist", str);
      if (!paramBoolean3) {
        break label147;
      }
    }
    label140:
    label147:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isLocalAppExist", str);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_download_cost", true, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QFlutter.Reporter", 1, String.format("reportDownloadCost: %s", new Object[] { Long.valueOf(paramLong) }));
      return;
      str = "0";
      break label24;
      str = "0";
      break label54;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Integer> paramMap)
  {
    if ((!needReport()) || (paramMap == null))
    {
      QLog.d("QFlutter.Reporter", 1, "reportMemoryIncrement, don't need report or mBeforeMemoryInfo == null");
      return;
    }
    int i = Build.VERSION.SDK_INT;
    long l1 = aqgz.getSystemTotalMemory() / 1024L / 1024L;
    float f = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
    Object localObject = aqgz.g(BaseApplicationImpl.getContext());
    long l2 = a("summary.total-pss", paramMap, (Map)localObject);
    long l3 = a("summary.java-heap", paramMap, (Map)localObject);
    long l4 = a("summary.native-heap", paramMap, (Map)localObject);
    long l5 = a("summary.graphics", paramMap, (Map)localObject);
    long l6 = a("summary.code", paramMap, (Map)localObject);
    long l7 = a("summary.private-other", paramMap, (Map)localObject);
    localObject = aqgz.BZ();
    HashMap localHashMap = new HashMap();
    if (paramBoolean1) {}
    for (paramMap = "1";; paramMap = "0")
    {
      localHashMap.put("isFirstLoad", paramMap);
      localHashMap.put("sdkVersion", String.valueOf(i));
      localHashMap.put("resolution", localObject);
      localHashMap.put("totalMemory", String.valueOf(l1));
      localHashMap.put("maxMemory", String.valueOf(f));
      localHashMap.put("totalPss", String.valueOf(l2));
      localHashMap.put("javaPss", String.valueOf(l3));
      localHashMap.put("nativePss", String.valueOf(l4));
      localHashMap.put("graphicsPss", String.valueOf(l5));
      localHashMap.put("codePss", String.valueOf(l6));
      localHashMap.put("otherPss", String.valueOf(l7));
      if (!paramBoolean2) {
        break;
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_enter_memory_increment", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_exit_memory_increment", true, 0L, 0L, localHashMap, "", false);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    HashMap localHashMap;
    if (needReport())
    {
      localHashMap = new HashMap();
      if (!paramBoolean1) {
        break label228;
      }
      str = "1";
      localHashMap.put("isFirstLaunch", str);
      if (!paramBoolean2) {
        break label235;
      }
      str = "1";
      label41:
      localHashMap.put("isLocalResExist", str);
      if (!paramBoolean3) {
        break label242;
      }
    }
    label228:
    label235:
    label242:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isPreloadProcess", str);
      localHashMap.put("totalCost", String.valueOf(paramLong1));
      localHashMap.put("loadProcessCost", String.valueOf(paramLong2));
      localHashMap.put("launchCost", String.valueOf(paramLong3));
      localHashMap.put("openPageCost", String.valueOf(paramLong4));
      localHashMap.put("flutterUin", getUin());
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_first_frame", true, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.Reporter", 2, String.format("reportFirstFrameCost, isFirstLaunch: %s, isLocalResExist: %s, isPreloadProcess: %s,totalCost: %s, loadProcessCost: %s, launchCost: %s, openPageCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) }));
      }
      return;
      str = "0";
      break;
      str = "0";
      break label41;
    }
  }
  
  public static void an(String paramString, long paramLong)
  {
    if (needReport())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pagePath", paramString);
      localHashMap.put("cost", String.valueOf(paramLong));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_page_render_cost", true, 0L, 0L, localHashMap, "", false);
    }
  }
  
  private static String getUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  public static boolean needReport()
  {
    return ahfg.a().needReport();
  }
  
  public static void reportException(String paramString)
  {
    if (needReport())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pagePath", paramString);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "qq_flutter_exception", true, 0L, 0L, localHashMap, "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgd
 * JD-Core Version:    0.7.0.1
 */