import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class awsp
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  awsp(awsk paramawsk) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.this$0.threshold)
    {
      awsk.a(this.this$0);
      if (awsk.a(this.this$0)) {
        this.this$0.eFL();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsp
 * JD-Core Version:    0.7.0.1
 */