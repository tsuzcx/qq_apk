import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class xsu
  implements INetInfoHandler
{
  xsu(xss paramxss) {}
  
  public void onNetMobile2None()
  {
    xss.b(this.a, xss.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    xss.b(this.a, xss.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    xss.b(this.a, xss.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    xss.b(this.a, xss.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    xss.b(this.a, xss.a(2));
  }
  
  public void onNetWifi2None()
  {
    xss.b(this.a, xss.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsu
 * JD-Core Version:    0.7.0.1
 */