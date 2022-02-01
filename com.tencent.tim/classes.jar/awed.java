import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awed
{
  public static void B(String paramString1, String paramString2, long paramLong)
  {
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, paramLong, 0L, new HashMap(), null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " duration:" + paramLong);
    }
  }
  
  public static void ad(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString3);
    localHashMap.put("reserve", paramString4);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " resultCode:" + paramString3 + " reserve:" + paramString4);
    }
  }
  
  public static void ae(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      paramString3 = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramString3 = "0";
      }
      localHashMap.put("refer", str);
      localHashMap.put("type", paramString3);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str + "type =" + paramString3);
  }
  
  public static void bD(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      localHashMap.put("refer", str);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str);
  }
  
  public static void bE(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "unfinedsource";
      }
      localHashMap.put("event_result", str);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " refer = " + str);
  }
  
  public static void e(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramHashMap);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2);
    }
  }
  
  public static void jx(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, new HashMap(), null);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2);
  }
  
  public static void t(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString3, paramString4);
    localHashMap.put("reserve", paramString5);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " key:" + paramString3 + " value:" + paramString4 + ", reserve:" + paramString5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awed
 * JD-Core Version:    0.7.0.1
 */