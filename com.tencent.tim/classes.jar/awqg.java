import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class awqg
  implements INetInfoHandler
{
  awqg(awqd paramawqd) {}
  
  public void onNetMobile2None()
  {
    this.b.cM(false, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.b.cM(true, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.b.cM(false, true);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.b.cM(true, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.b.cM(false, true);
  }
  
  public void onNetWifi2None()
  {
    this.b.cM(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqg
 * JD-Core Version:    0.7.0.1
 */