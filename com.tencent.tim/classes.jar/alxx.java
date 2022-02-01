import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.qphone.base.util.QLog;

public class alxx
  implements HWDecodeListener
{
  public alxx(FollowCaptureView paramFollowCaptureView) {}
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    FollowCaptureView.a(this.this$0, paramLong1);
  }
  
  public void onDecodeRepeat()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FollowCaptureView", 2, "onDecodeRepeat");
    }
    FollowCaptureView.a(this.this$0);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxx
 * JD-Core Version:    0.7.0.1
 */