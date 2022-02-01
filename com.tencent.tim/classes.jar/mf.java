import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class mf
{
  public static HashMap<String, Integer> F = new HashMap();
  public static HashMap<String, Integer> G;
  
  static
  {
    F.put("actLbsSendPoiListFailure", Integer.valueOf(100));
    F.put("actLbsSendGetPidFailure", Integer.valueOf(100));
    F.put("actLbsPayBridgeFailure", Integer.valueOf(100));
    F.put("actLbsPoiListFailure", Integer.valueOf(10000));
    F.put("actLbsPackListFailure", Integer.valueOf(1000));
    F.put("actLbsGetPackFailure", Integer.valueOf(100));
    F.put("actLbsCaiShenResourceFailure", Integer.valueOf(100));
    G = new HashMap();
    G.put("actLbsSendPoiListFailure", Integer.valueOf(10000));
    G.put("actLbsSendGetPidFailure", Integer.valueOf(10000));
    G.put("actLbsPayBridgeFailure", Integer.valueOf(10000));
    G.put("actLbsPoiListFailure", Integer.valueOf(100000));
    G.put("actLbsPackListFailure", Integer.valueOf(10000));
    G.put("actLbsGetPackFailure", Integer.valueOf(10000));
    G.put("actLbsCaiShenResourceFailure", Integer.valueOf(10000));
  }
  
  public static boolean H(String paramString)
  {
    paramString = (Integer)F.get(paramString);
    if (paramString == null) {
      return false;
    }
    return (int)(Math.random() * paramString.intValue()) == 1;
  }
  
  public static boolean J(String paramString)
  {
    paramString = (Integer)G.get(paramString);
    if (paramString == null) {
      return false;
    }
    return (int)(Math.random() * paramString.intValue()) == 1;
  }
  
  public static void W(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (J(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "uploadSuccess " + paramString);
        }
        anpc.a(MobileQQ.sMobileQQ).collectPerformance(str, paramString, false, 0L, 0L, localHashMap, null);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void o(String paramString, int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (H(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "uploadFailure " + paramString + " " + paramInt);
        }
        anpc.a(MobileQQ.sMobileQQ).collectPerformance(str, paramString, true, 0L, 0L, localHashMap, null);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mf
 * JD-Core Version:    0.7.0.1
 */