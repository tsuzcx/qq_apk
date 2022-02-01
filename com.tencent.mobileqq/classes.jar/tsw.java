import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class tsw
  implements INetInfoHandler
{
  protected WeakReference<tmz> a;
  
  public tsw(tmz paramtmz)
  {
    this.a = new WeakReference(paramtmz);
  }
  
  public void onNetMobile2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((tmz)this.a.get()).c();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((tmz)this.a.get()).i();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      ((tmz)this.a.get()).g();
      ((tmz)this.a.get()).i();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((tmz)this.a.get()).i();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((tmz)this.a.get()).h();
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((tmz)this.a.get()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsw
 * JD-Core Version:    0.7.0.1
 */