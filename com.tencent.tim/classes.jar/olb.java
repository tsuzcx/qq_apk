import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class olb
  implements INetInfoHandler
{
  private WSPlayerManager a;
  
  public olb(WSPlayerManager paramWSPlayerManager)
  {
    this.a = paramWSPlayerManager;
  }
  
  private void bfE()
  {
    if ((this.a != null) && (this.a.b() != null))
    {
      ole localole = this.a.b();
      if ((!this.a.GY()) && (!this.a.isError())) {
        break label55;
      }
      this.a.c(localole, false);
    }
    label55:
    while (!this.a.GZ()) {
      return;
    }
    this.a.start();
  }
  
  public void onNetMobile2None()
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetMobile2Wifi s:" + paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetNone2Mobile s:" + paramString);
    bfE();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetNone2Wifi s:" + paramString);
    bfE();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetWifi2Mobile s:" + paramString);
  }
  
  public void onNetWifi2None()
  {
    ooz.d("WSPlayerForNetInfoHandler", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olb
 * JD-Core Version:    0.7.0.1
 */