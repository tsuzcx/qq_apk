package cooperation.qzone.report;

import avzl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QzoneOnlineTimeCollectRptService$3
  implements Runnable
{
  public QzoneOnlineTimeCollectRptService$3(avzl paramavzl) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(avzl.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneOnlineTimeCollectRptService", 2, "mOnlineTimeCheckTraceRunnable run");
    }
    this.this$0.eCR();
    ThreadManager.getSubThreadHandler().postDelayed(this, avzl.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3
 * JD-Core Version:    0.7.0.1
 */