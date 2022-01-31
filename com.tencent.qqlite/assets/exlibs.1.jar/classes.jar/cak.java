import android.os.Handler;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import java.util.TimerTask;

public class cak
  extends TimerTask
{
  public cak(FraudTipsBar paramFraudTipsBar) {}
  
  public void run()
  {
    FraudTipsBar.a(this.a).post(new cal(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cak
 * JD-Core Version:    0.7.0.1
 */