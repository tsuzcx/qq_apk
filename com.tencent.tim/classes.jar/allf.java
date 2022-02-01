import android.app.Application;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;

public class allf
{
  private static volatile boolean cxA;
  
  static {}
  
  public static void a(Application paramApplication, SDKInitListener paramSDKInitListener)
  {
    VideoPlaySDKManager.getInstance().initSDKAsync(paramApplication, paramSDKInitListener);
  }
  
  public static boolean atK()
  {
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
  
  public static void dGz()
  {
    try
    {
      if (!cxA)
      {
        LogUtil.setLogImp(new alll());
        ThreadUtil.setThreadImp(new allo());
        LoadSoUtil.setLoadSoImp(new allj());
        ReportUtil.setReportImp(new alln());
        RegisterTVideoUtil.setRegisterTVideoImp(new allm());
        cxA = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isSDKReady()
  {
    return VideoPlaySDKManager.getInstance().isSDKReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allf
 * JD-Core Version:    0.7.0.1
 */