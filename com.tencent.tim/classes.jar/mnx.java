import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class mnx
  implements INetInfoHandler
{
  mnx(mnw parammnw) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetNone2Mobile");
    mnw.a(this.this$0);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetWifi2Mobile");
    mnw.a(this.this$0);
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnx
 * JD-Core Version:    0.7.0.1
 */