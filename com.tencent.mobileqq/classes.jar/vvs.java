import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class vvs
  implements SDKInitListener
{
  vvs(vvq paramvvq) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.i("QCIRCLE_PLUGIN", 4, "preload playSdk success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvs
 * JD-Core Version:    0.7.0.1
 */