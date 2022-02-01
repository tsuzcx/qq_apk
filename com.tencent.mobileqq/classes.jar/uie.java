import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class uie
  implements INetInfoHandler
{
  protected WeakReference<ujb> a;
  
  public uie(ujb paramujb)
  {
    this.a = new WeakReference(paramujb);
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ujb)this.a.get()).d();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ujb)this.a.get()).b();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ujb)this.a.get()).c();
    }
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uie
 * JD-Core Version:    0.7.0.1
 */