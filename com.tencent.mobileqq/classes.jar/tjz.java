import android.util.Log;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class tjz
{
  private static tjz a;
  public static boolean a;
  
  private tjz()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Log.w("weishi-beacon", "request is more than " + paramLong2);
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static tjz a()
  {
    try
    {
      if (jdField_a_of_type_Tjz == null) {
        jdField_a_of_type_Tjz = new tjz();
      }
      tjz localtjz = jdField_a_of_type_Tjz;
      return localtjz;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedUserUsageDuration", String.valueOf(paramLong1));
    localHashMap.put("actWsFeedListFirstReqDuration", String.valueOf(paramLong2));
    localHashMap.put("actWsFeedCoverExposureNum", String.valueOf(paramInt));
    if (paramBoolean1)
    {
      localHashMap.put("actWsFeedIsJumpToPlayPage", "true");
      if (!paramBoolean2) {
        break label177;
      }
      localHashMap.put("actWsFeedIsJumpToWeiShi", "true");
    }
    for (;;)
    {
      azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedUserConsumption", true, 0L, 0L, localHashMap, "");
      Log.w("weishi-beacon", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      tlq.jdField_a_of_type_Boolean = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label177:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", " actWsFeedPageLoadDuration=" + paramLong);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsFeedPicBytes", "" + paramLong2);
    Log.i("actWsGzhFeedPerformance", "actWsFeedPicBytes=" + paramLong2);
    azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.i("weishi-beacon", "actWsFeedPicReqDuration=" + paramLong1);
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSFeedListReqDuration", "" + paramLong);
    azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWSFeedListReqDuration=" + paramLong);
  }
  
  public void c(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedNotificationReqDuration", "" + paramLong);
    azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWsFeedNotificationReqDuration=" + paramLong);
  }
  
  public void d(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPlayPageLoadDuration", "" + paramLong);
    azri.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWsPlayPageLoadDuration=" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjz
 * JD-Core Version:    0.7.0.1
 */