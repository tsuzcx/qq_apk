import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class aazi
  implements SDKInitListener
{
  public aazi(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.e("ShortVideoPlayActivity", 1, "initSDKAsync failed!");
      return;
    }
    QLog.d("ShortVideoPlayActivity", 1, "initSDKAsync succeed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazi
 * JD-Core Version:    0.7.0.1
 */