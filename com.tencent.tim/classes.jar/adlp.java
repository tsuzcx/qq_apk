import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.ARScanEntryView.4.1;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView.a;
import com.tencent.qphone.base.util.QLog;

public class adlp
  implements ScanIconAnimateView.a
{
  public adlp(ARScanEntryView paramARScanEntryView) {}
  
  public void onEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onEnd  needReportRedDot = " + ARScanEntryView.a(this.this$0));
    }
    if (ARScanEntryView.a(this.this$0) != null) {
      ARScanEntryView.a(this.this$0).post(new ARScanEntryView.4.1(this));
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onStart ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlp
 * JD-Core Version:    0.7.0.1
 */