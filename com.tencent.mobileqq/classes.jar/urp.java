import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class urp
  implements INetInfoHandler
{
  private WeakReference<WSPlayerManager> a;
  
  public urp(WSPlayerManager paramWSPlayerManager)
  {
    this.a = new WeakReference(paramWSPlayerManager);
  }
  
  private void a()
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.a() != null))
    {
      urt localurt = localWSPlayerManager.a();
      if ((!localWSPlayerManager.f()) && (!localWSPlayerManager.e())) {
        break label48;
      }
      localWSPlayerManager.b(localurt, false);
    }
    label48:
    while (!localWSPlayerManager.g()) {
      return;
    }
    localWSPlayerManager.a();
  }
  
  public void onNetMobile2None()
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetMobile2Wifi s:" + paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetNone2Mobile s:" + paramString);
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetNone2Wifi s:" + paramString);
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetWifi2Mobile s:" + paramString);
  }
  
  public void onNetWifi2None()
  {
    uya.b("WSPlayerForNetInfoHandler", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */