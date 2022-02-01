import com.tencent.mobileqq.activity.aio.AIOTimeReporter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class wiv
{
  private static String aSn = "HighDeviceFirstOpenAIOBusiness";
  private static String aSo = "HighDeviceFirstOpenAIOBase";
  private static String aSp = "HighDeviceNotFirstOpenAIOBusiness";
  private static String aSq = "HighDeviceNotFirstOpenAIOBase";
  private static String aSr = "MidDeviceFirstOpenAIOBusiness";
  private static String aSs = "MidDeviceFirstOpenAIOBase";
  private static String aSt = "MidDeviceNotFirstOpenAIOBusiness";
  private static String aSu = "MidDeviceNotFirstOpenAIOBase";
  private static String aSv = "LowDeviceFirstOpenAIOBusiness";
  private static String aSw = "LowDeviceFirstOpenAIOBase";
  private static String aSx = "LowDeviceNotFirstOpenAIOBusiness";
  private static String aSy = "LowDeviceNotFirstOpenAIOBase";
  public String TAG = "Q.aio.AIOTimeReporter";
  private String aSm = "0";
  private int bvB = -1;
  
  private void reSet()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "reSet ");
    }
    this.bvB = -1;
    this.aSm = "0";
  }
  
  public void bYs()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "reportAIOLifeCycleTime ");
    }
    if (new Random().nextInt(100) != 1)
    {
      reSet();
      return;
    }
    ThreadManager.post(new AIOTimeReporter.1(this), 1, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wiv
 * JD-Core Version:    0.7.0.1
 */