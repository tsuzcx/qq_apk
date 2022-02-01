import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class avmu
  implements INetInfoHandler
{
  avmu(avmt paramavmt) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    avmt.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    avmt.a(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmu
 * JD-Core Version:    0.7.0.1
 */