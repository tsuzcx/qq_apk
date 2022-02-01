import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.qphone.base.util.QLog;

public class adle
  implements MessageQueue.IdleHandler
{
  public adle(ARScanEntryView paramARScanEntryView) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "queueIdle called ");
    }
    if ((ARScanEntryView.a(this.this$0) != null) && (this.this$0.uA)) {
      ARScanEntryView.a(this.this$0).dDg();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adle
 * JD-Core Version:    0.7.0.1
 */