import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class yze
  implements INetInfoHandler
{
  public yze(DataLineHandler paramDataLineHandler) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.c();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.c();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.d();
  }
  
  public void onNetWifi2None()
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yze
 * JD-Core Version:    0.7.0.1
 */