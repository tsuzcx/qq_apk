import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class adqk
  implements INetInfoHandler
{
  public adqk(ArkAppCenter paramArkAppCenter) {}
  
  public void onNetMobile2None()
  {
    ArkAppCenter.a(this.b, 1, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ArkAppCenter.a(this.b, 1, 2);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ArkAppCenter.a(this.b, 0, 1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ArkAppCenter.a(this.b, 0, 2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ArkAppCenter.a(this.b, 2, 1);
  }
  
  public void onNetWifi2None()
  {
    ArkAppCenter.a(this.b, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqk
 * JD-Core Version:    0.7.0.1
 */