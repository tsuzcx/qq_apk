import android.os.Handler;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class zbh
  implements INetInfoHandler
{
  public zbh(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onNetMobile2None()
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetMobile2None()");
    GdtVideoCommonView.a(this.a, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    GdtVideoCommonView.a(this.a, 1);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetNone2Mobile() apn=" + paramString + " onNetWifi2None " + GdtVideoCommonView.c(this.a));
    GdtVideoCommonView.a(this.a, 2);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    GdtVideoCommonView.a(this.a, 1);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    GdtVideoCommonView.a(this.a, 2);
    if ((this.a.a) && (this.a.a()))
    {
      GdtVideoCommonView.d(this.a);
      GdtVideoCommonView.a(this.a).post(GdtVideoCommonView.a(this.a));
    }
  }
  
  public void onNetWifi2None()
  {
    yxs.b("GdtVideoCommonView", "INetInfoHandler onNetWifi2None()");
    GdtVideoCommonView.b(this.a, true);
    GdtVideoCommonView.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbh
 * JD-Core Version:    0.7.0.1
 */