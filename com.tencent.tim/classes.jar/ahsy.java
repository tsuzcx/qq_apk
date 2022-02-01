import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class ahsy
  implements SDKInitListener
{
  public ahsy(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("GameCenterVideoViewController", 4, "onSDKInited result:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsy
 * JD-Core Version:    0.7.0.1
 */