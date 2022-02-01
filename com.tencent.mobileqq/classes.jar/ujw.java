import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class ujw
  implements INetInfoHandler
{
  private WSPlayerManager a;
  
  public ujw(WSPlayerManager paramWSPlayerManager)
  {
    this.a = paramWSPlayerManager;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.a() != null))
    {
      ukb localukb = this.a.a();
      if ((!this.a.f()) && (!this.a.e())) {
        break label55;
      }
      this.a.b(localukb, false);
    }
    label55:
    while (!this.a.g()) {
      return;
    }
    this.a.a();
  }
  
  public void onNetMobile2None()
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetMobile2Wifi s:" + paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetNone2Mobile s:" + paramString);
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetNone2Wifi s:" + paramString);
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetWifi2Mobile s:" + paramString);
  }
  
  public void onNetWifi2None()
  {
    upe.b("WSPlayerForNetInfoHandler", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */