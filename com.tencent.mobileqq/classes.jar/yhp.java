import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class yhp
  implements INetInfoHandler
{
  yhp(yhn paramyhn) {}
  
  public void onNetMobile2None()
  {
    yhn.b(this.a, yhn.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    yhn.b(this.a, yhn.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    yhn.b(this.a, yhn.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    yhn.b(this.a, yhn.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    yhn.b(this.a, yhn.a(2));
  }
  
  public void onNetWifi2None()
  {
    yhn.b(this.a, yhn.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhp
 * JD-Core Version:    0.7.0.1
 */