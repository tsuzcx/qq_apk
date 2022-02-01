import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class tau
  implements SDKInitListener
{
  public tau(GameCenterActivity paramGameCenterActivity) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterActivity", 1, "QQVideo Inited:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tau
 * JD-Core Version:    0.7.0.1
 */