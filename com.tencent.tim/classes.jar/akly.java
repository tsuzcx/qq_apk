import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class akly
  extends ahqw
{
  public akly(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a(ahqy paramahqy)
  {
    this.this$0.e.obtainMessage(102, paramahqy).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, ahqy paramahqy)
  {
    if (!OCRPerformFragment.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "onPicOcrResult other!");
      }
      return;
    }
    this.this$0.e.removeMessages(101);
    OCRPerformFragment.a(this.this$0, false);
    OCRPerformFragment.a(this.this$0).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramahqy));
  }
  
  public void dpr()
  {
    this.this$0.e.sendEmptyMessageDelayed(101, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akly
 * JD-Core Version:    0.7.0.1
 */