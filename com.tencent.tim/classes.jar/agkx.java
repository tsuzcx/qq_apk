import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class agkx
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("FileVideoDownloadManager<FileAssistant>XOXO", 1, "initSDKAsync failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkx
 * JD-Core Version:    0.7.0.1
 */