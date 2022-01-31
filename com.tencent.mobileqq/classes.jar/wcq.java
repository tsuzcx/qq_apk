import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import java.util.TimerTask;
import mqq.os.MqqHandler;

public class wcq
  extends TimerTask
{
  public wcq(FraudTipsBar paramFraudTipsBar) {}
  
  public void run()
  {
    FraudTipsBar.a(this.a).post(new wcr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcq
 * JD-Core Version:    0.7.0.1
 */