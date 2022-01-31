import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class vbf
  implements INetInfoHandler
{
  vbf(vbd paramvbd) {}
  
  public void onNetMobile2None()
  {
    vbd.b(this.a, vbd.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    vbd.b(this.a, vbd.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    vbd.b(this.a, vbd.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    vbd.b(this.a, vbd.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    vbd.b(this.a, vbd.a(2));
  }
  
  public void onNetWifi2None()
  {
    vbd.b(this.a, vbd.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbf
 * JD-Core Version:    0.7.0.1
 */