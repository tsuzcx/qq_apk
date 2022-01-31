import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class xuq
  implements INetInfoHandler
{
  public xuq(LbsFilterStatusManager paramLbsFilterStatusManager) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (LbsFilterStatusManager.a(this.a) == l) {
      LbsFilterStatusManager.a(this.a);
    }
    while (LbsFilterStatusManager.a(this.a) == null) {
      return;
    }
    LbsFilterStatusManager.a(this.a).post(new xur(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuq
 * JD-Core Version:    0.7.0.1
 */