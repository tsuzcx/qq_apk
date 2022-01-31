import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class vbc
  implements INetInfoHandler
{
  vbc(vba paramvba) {}
  
  public void onNetMobile2None()
  {
    vba.b(this.a, vba.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    vba.b(this.a, vba.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    vba.b(this.a, vba.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    vba.b(this.a, vba.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    vba.b(this.a, vba.a(2));
  }
  
  public void onNetWifi2None()
  {
    vba.b(this.a, vba.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbc
 * JD-Core Version:    0.7.0.1
 */