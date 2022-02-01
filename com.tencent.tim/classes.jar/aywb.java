import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;

public class aywb
  implements INetInfoHandler
{
  aywb(aywa paramaywa) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper()) {
      aywa.a(this.this$0);
    }
    while (aywa.a(this.this$0) == null) {
      return;
    }
    aywa.a(this.this$0).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywb
 * JD-Core Version:    0.7.0.1
 */