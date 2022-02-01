import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class aavj
  implements INetInfoHandler
{
  aavj(aavi paramaavi) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (aavi.a(this.this$0) == l) {
      aavi.a(this.this$0);
    }
    while (aavi.a(this.this$0) == null) {
      return;
    }
    aavi.a(this.this$0).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavj
 * JD-Core Version:    0.7.0.1
 */