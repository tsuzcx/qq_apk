import android.os.Handler;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class tmm
  implements INetInfoHandler
{
  public tmm(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onNetMobile2None()
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetMobile2None()");
    GdtVideoCommonView.a(this.this$0, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    GdtVideoCommonView.a(this.this$0, 1);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetNone2Mobile() apn=" + paramString + " onNetWifi2None " + GdtVideoCommonView.c(this.this$0));
    GdtVideoCommonView.a(this.this$0, 2);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    GdtVideoCommonView.a(this.this$0, 1);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    GdtVideoCommonView.a(this.this$0, 2);
    if ((this.this$0.aPq) && (this.this$0.EF()))
    {
      GdtVideoCommonView.d(this.this$0);
      GdtVideoCommonView.a(this.this$0).post(GdtVideoCommonView.a(this.this$0));
    }
  }
  
  public void onNetWifi2None()
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetWifi2None()");
    GdtVideoCommonView.b(this.this$0, true);
    GdtVideoCommonView.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmm
 * JD-Core Version:    0.7.0.1
 */