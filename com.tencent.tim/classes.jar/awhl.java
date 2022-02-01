import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Map;

public class awhl
{
  public static void a(Integer paramInteger, Long paramLong)
  {
    Map localMap = b(paramLong);
    localMap.put(paramInteger, Long.valueOf(System.currentTimeMillis() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + paramInteger + "timestamp: " + System.currentTimeMillis() / 1000L);
    }
    b(localMap, paramLong);
  }
  
  public static Map<Integer, Long> b(Long paramLong)
  {
    return d(paramLong.longValue());
  }
  
  public static void b(Map<Integer, Long> paramMap, Long paramLong)
  {
    LocalMultiProcConfig.putString("CTIME_MAP" + paramLong, awef.j(paramMap));
  }
  
  private static Map<Integer, Long> d(long paramLong)
  {
    Map localMap = awef.v(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhl
 * JD-Core Version:    0.7.0.1
 */