import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class tbf
  implements SDKInitListener
{
  public tbf(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 1, "QQVideo Inited:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */