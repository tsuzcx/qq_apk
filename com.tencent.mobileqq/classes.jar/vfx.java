import android.os.Looper;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerForNetInfoHandler.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class vfx
  implements INetInfoHandler
{
  private WeakReference<WSPlayerManager> a;
  
  public vfx(WSPlayerManager paramWSPlayerManager)
  {
    this.a = new WeakReference(paramWSPlayerManager);
  }
  
  private void a()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b();
      return;
    }
    ThreadManager.getUIHandler().post(new WSPlayerForNetInfoHandler.1(this));
  }
  
  private void b()
  {
    vmp.e("WSPlayerForNetInfoHandler", "[handleConnectNetWorkChange] thread:" + Thread.currentThread());
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.a() != null))
    {
      vgb localvgb = localWSPlayerManager.a();
      if ((!localWSPlayerManager.f()) && (!localWSPlayerManager.e())) {
        break label74;
      }
      localWSPlayerManager.b(localvgb, false);
    }
    label74:
    while (!localWSPlayerManager.g()) {
      return;
    }
    localWSPlayerManager.a();
  }
  
  public void onNetMobile2None()
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetMobile2None] thread:" + Thread.currentThread());
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetMobile2Wifi] s:" + paramString + ", thread:" + Thread.currentThread());
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetNone2Mobile] s:" + paramString + ", thread:" + Thread.currentThread());
    a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetNone2Wifi] s:" + paramString + ", thread:" + Thread.currentThread());
    a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetWifi2Mobile] s:" + paramString + ", thread:" + Thread.currentThread());
  }
  
  public void onNetWifi2None()
  {
    vmp.b("WSPlayerForNetInfoHandler", "[onNetWifi2None] thread:" + Thread.currentThread());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfx
 * JD-Core Version:    0.7.0.1
 */