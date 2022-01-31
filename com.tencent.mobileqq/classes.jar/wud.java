import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class wud
  implements INetInfoHandler
{
  wud(wub paramwub) {}
  
  public void onNetMobile2None()
  {
    wub.b(this.a, wub.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    wub.b(this.a, wub.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    wub.b(this.a, wub.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    wub.b(this.a, wub.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    wub.b(this.a, wub.a(2));
  }
  
  public void onNetWifi2None()
  {
    wub.b(this.a, wub.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wud
 * JD-Core Version:    0.7.0.1
 */