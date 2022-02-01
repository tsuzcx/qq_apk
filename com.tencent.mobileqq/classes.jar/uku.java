import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class uku
  implements INetInfoHandler
{
  private WSPlayerManager a;
  
  public uku(WSPlayerManager paramWSPlayerManager)
  {
    this.a = paramWSPlayerManager;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.a() != null))
    {
      ukz localukz = this.a.a();
      if ((!this.a.f()) && (!this.a.e())) {
        break label55;
      }
      this.a.b(localukz, false);
    }
    label55:
    while (!this.a.g()) {
      return;
    }
    this.a.a();
  }
  
  public void onNetMobile2None()
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetMobile2Wifi s:" + paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetNone2Mobile s:" + paramString);
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetNone2Wifi s:" + paramString);
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetWifi2Mobile s:" + paramString);
  }
  
  public void onNetWifi2None()
  {
    uqf.b("WSPlayerForNetInfoHandler", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uku
 * JD-Core Version:    0.7.0.1
 */