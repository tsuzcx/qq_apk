import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

class ahex
  extends ahey
{
  ahex(ahew paramahew) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordPageView: %s", new Object[] { paramString }));
    }
    ahgd.JY(paramString);
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("reportPageLoadTime: pathPath: %s, loadTime: %s", new Object[] { paramString, paramInteger }));
    }
    ahgd.an(paramString, paramInteger.intValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, Double paramDouble, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordFPS: pathPath: %s, fps: %s, dropRate: %s", new Object[] { paramString, paramInteger, paramDouble }));
    }
    ahgd.a(paramString, paramInteger.intValue(), paramDouble.doubleValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, MethodChannel.Result paramResult)
  {
    QLog.e("flutter.APMChannel", 1, String.format("reportException, msg: %s, stack: %s", new Object[] { paramString3, paramString4 }));
    CrashReport.postException(paramInteger.intValue(), paramString2, paramString3, paramString4, paramHashMap);
    ahgd.reportException(paramString1);
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahex
 * JD-Core Version:    0.7.0.1
 */