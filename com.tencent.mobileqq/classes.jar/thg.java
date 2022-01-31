import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class thg
  implements INetInfoHandler
{
  private WSPlayerManager a;
  
  public thg(WSPlayerManager paramWSPlayerManager)
  {
    this.a = paramWSPlayerManager;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.a() != null))
    {
      thl localthl = this.a.a();
      if ((!this.a.f()) && (!this.a.e())) {
        break label55;
      }
      this.a.b(localthl, false);
    }
    label55:
    while (!this.a.g()) {
      return;
    }
    this.a.a();
  }
  
  public void onNetMobile2None()
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetMobile2Wifi s:" + paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetNone2Mobile s:" + paramString);
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetNone2Wifi s:" + paramString);
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetWifi2Mobile s:" + paramString);
  }
  
  public void onNetWifi2None()
  {
    tlo.b("WSPlayerForNetInfoHandler", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thg
 * JD-Core Version:    0.7.0.1
 */