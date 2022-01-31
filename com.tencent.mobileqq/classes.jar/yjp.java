import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.utils.QLog;

class yjp
  extends AVVideoCtrl.EnableCameraCompleteCallback
{
  yjp(yjk paramyjk) {}
  
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVCameraCaptureModel", 0, "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */