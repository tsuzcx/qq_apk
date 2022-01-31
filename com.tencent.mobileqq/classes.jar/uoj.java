import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class uoj
  implements INetInfoHandler
{
  uoj(uoh paramuoh) {}
  
  public void onNetMobile2None()
  {
    uoh.b(this.a, uoh.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    uoh.b(this.a, uoh.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    uoh.b(this.a, uoh.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    uoh.b(this.a, uoh.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    uoh.b(this.a, uoh.a(2));
  }
  
  public void onNetWifi2None()
  {
    uoh.b(this.a, uoh.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */