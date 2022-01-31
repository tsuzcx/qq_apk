import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class umo
  implements Runnable
{
  public umo(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing())
    {
      QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim run isFinishing return");
      return;
    }
    PraiseConfigHelper.a(this.a.app);
    Message localMessage = this.a.a.obtainMessage(13, 0, 0);
    this.a.a.sendMessageDelayed(localMessage, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umo
 * JD-Core Version:    0.7.0.1
 */