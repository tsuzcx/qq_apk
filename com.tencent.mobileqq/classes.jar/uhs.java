import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;

public class uhs
  implements Runnable
{
  public uhs(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    PraiseConfigHelper.a(this.a.app);
    Message localMessage = this.a.a.obtainMessage(13, 0, 0);
    this.a.a.sendMessageDelayed(localMessage, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */