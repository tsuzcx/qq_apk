import com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class awsq
  implements QWalletFaceTracker.OnPreviewFrameHandlerListener
{
  awsq(awsk paramawsk) {}
  
  public void getFaceRecognizeResult(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getFaceRecognizeResult=" + paramFloat);
    }
    if (paramFloat >= this.this$0.threshold)
    {
      awsk.a(this.this$0);
      if (awsk.a(this.this$0)) {
        this.this$0.eFL();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsq
 * JD-Core Version:    0.7.0.1
 */