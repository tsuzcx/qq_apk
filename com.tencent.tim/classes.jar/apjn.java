import android.os.CountDownTimer;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class apjn
  implements INetInfoHandler
{
  public apjn(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onNetMobile2None()
  {
    this.this$0.h.cancel();
    this.this$0.h.start();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.this$0.h.cancel();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.this$0.h.cancel();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.this$0.h.cancel();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.this$0.h.cancel();
  }
  
  public void onNetWifi2None()
  {
    this.this$0.h.cancel();
    this.this$0.h.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjn
 * JD-Core Version:    0.7.0.1
 */