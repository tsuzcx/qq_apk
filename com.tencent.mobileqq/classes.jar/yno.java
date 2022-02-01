import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class yno
  implements INetInfoHandler
{
  yno(ynm paramynm) {}
  
  public void onNetMobile2None()
  {
    ynm.b(this.a, ynm.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ynm.b(this.a, ynm.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ynm.b(this.a, ynm.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ynm.b(this.a, ynm.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ynm.b(this.a, ynm.a(2));
  }
  
  public void onNetWifi2None()
  {
    ynm.b(this.a, ynm.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */