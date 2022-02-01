import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class rvu
  implements rwe
{
  public rvu(ScannerActivity paramScannerActivity) {}
  
  public JSONObject Q()
  {
    try
    {
      JSONObject localJSONObject = ScannerActivity.a(this.a);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ScannerActivity", 1, "getQRReportParams error: " + localThrowable.getMessage());
    }
    return null;
  }
  
  public void bwZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "restartDecodeFrame");
    }
    this.a.finish();
  }
  
  public void bxa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "cameraOn");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvu
 * JD-Core Version:    0.7.0.1
 */