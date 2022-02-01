import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.qphone.base.util.QLog;

public class akos
  extends Handler
{
  public akos(ScanOcrView paramScanOcrView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "handleMessage, MSG_SCANLINE");
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.b.Sh(paramMessage.arg1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akos
 * JD-Core Version:    0.7.0.1
 */