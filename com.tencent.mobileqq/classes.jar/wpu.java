import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class wpu
  implements INetInfoHandler
{
  wpu(wps paramwps) {}
  
  public void onNetMobile2None()
  {
    wps.b(this.a, wps.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    wps.b(this.a, wps.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    wps.b(this.a, wps.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    wps.b(this.a, wps.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    wps.b(this.a, wps.a(2));
  }
  
  public void onNetWifi2None()
  {
    wps.b(this.a, wps.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpu
 * JD-Core Version:    0.7.0.1
 */