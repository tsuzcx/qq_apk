import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ajgt
{
  public static ajgs a;
  
  private static HashMap<String, String> R()
  {
    HashMap localHashMap = new HashMap();
    if (a != null)
    {
      ajgv.b("MsgBackup_MsgBackupReporter", "mReportContainer = %s", new Object[] { a });
      localHashMap.put("bizType", String.valueOf(a.bizType));
      localHashMap.put("platForm", String.valueOf(a.platForm));
      localHashMap.put("requestStatus", String.valueOf(a.cos));
      localHashMap.put("errorCode", String.valueOf(a.errorCode));
      localHashMap.put("totalCost", String.valueOf(a.totalCost));
      localHashMap.put("averageSpeed", String.valueOf(a.cN));
      localHashMap.put("totalSessionCount", String.valueOf(a.acq));
      localHashMap.put("finishedSessionCount", String.valueOf(a.acr));
      localHashMap.put("resSessionContains", String.valueOf(a.acs));
      localHashMap.put("resTotalSize", String.valueOf(a.act));
      localHashMap.put("dbTotalSize", String.valueOf(a.acu));
      localHashMap.put("resRequestCount", String.valueOf(a.acv));
      localHashMap.put("resRequestFailedCount", String.valueOf(a.acw));
      localHashMap.put("resRequestCancelCount", String.valueOf(a.acx));
      localHashMap.put("resTrivialCount", String.valueOf(a.acy));
      localHashMap.put("resTrivialFailedCount", String.valueOf(a.acz));
      localHashMap.put("resTrivialCancelCount", String.valueOf(a.acA));
      localHashMap.put("dbRequestCount", String.valueOf(a.acB));
      localHashMap.put("dbRequestFailedCount", String.valueOf(a.acC));
      localHashMap.put("dbRequestCancelCount", String.valueOf(a.acD));
      localHashMap.put("udpDetected", String.valueOf(a.udpDetected));
      localHashMap.put("connectType", String.valueOf(a.connectType));
      localHashMap.put("connectElipse", String.valueOf(a.acE));
      localHashMap.put("sessionReadyAllTimes", String.valueOf(a.acF));
      localHashMap.put("fileFailedCount", String.valueOf(a.acG));
      localHashMap.put("fileErrorList", String.valueOf(a.xI));
    }
    return localHashMap;
  }
  
  public static void ao(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt1 + "], reservedFromType = [" + paramInt2 + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void cN(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void dxs()
  {
    if (a == null)
    {
      a = new ajgs();
      a.clear();
      a.platForm = 9;
    }
  }
  
  public static void dxt()
  {
    if (a != null)
    {
      a.clear();
      a = null;
    }
  }
  
  public static void dxu()
  {
    if (a != null)
    {
      HashMap localHashMap = R();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "MsgBackup_MsgBackupReporter", true, 0L, 0L, localHashMap, null);
      dxt();
    }
  }
  
  public static void report(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + paramString + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgt
 * JD-Core Version:    0.7.0.1
 */