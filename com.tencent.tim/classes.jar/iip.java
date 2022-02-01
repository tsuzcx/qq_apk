import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class iip
  implements INetInfoHandler
{
  VideoAppInterface mApp;
  
  public iip(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2None");
    }
    VideoController localVideoController = this.mApp.b();
    if (localVideoController != null) {
      localVideoController.kn(0);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2Wifi");
    }
    paramString = this.mApp.b();
    if (paramString != null) {
      paramString.kn(1);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Mobile");
    }
    paramString = this.mApp.b();
    if (paramString != null) {
      paramString.kn(2);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Wifi");
    }
    paramString = this.mApp.b();
    if (paramString != null) {
      paramString.kn(1);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2Mobile");
    }
    paramString = this.mApp.b();
    if (paramString != null) {
      paramString.kn(2);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2None");
    }
    VideoController localVideoController = this.mApp.b();
    if (localVideoController != null) {
      localVideoController.kn(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iip
 * JD-Core Version:    0.7.0.1
 */