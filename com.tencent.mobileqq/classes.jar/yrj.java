import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class yrj
  implements INetInfoHandler
{
  yrj(yrh paramyrh) {}
  
  public void onNetMobile2None()
  {
    yrh.b(this.a, yrh.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    yrh.b(this.a, yrh.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    yrh.b(this.a, yrh.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    yrh.b(this.a, yrh.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    yrh.b(this.a, yrh.a(2));
  }
  
  public void onNetWifi2None()
  {
    yrh.b(this.a, yrh.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrj
 * JD-Core Version:    0.7.0.1
 */