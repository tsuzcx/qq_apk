import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class vgy
  implements SDKInitListener
{
  vgy(vgw paramvgw) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.i("QCIRCLE_PLUGIN", 4, "preload playSdk success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgy
 * JD-Core Version:    0.7.0.1
 */