import com.tencent.wstt.SSCM.SSCMTimer;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import com.tencent.wstt.SSCM.Utils;
import java.util.TimerTask;

public class icb
  extends TimerTask
{
  public icb(SSCMTimer paramSSCMTimer) {}
  
  public void run()
  {
    long l;
    int i;
    if (SSCMTimer.a(this.a))
    {
      l = Long.parseLong(Utils.a());
      if (l == -1L)
      {
        SSCMTimer.a(this.a, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        SSCMTimer.a(this.a, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - SSCMTimer.a(this.a));
          SSCMTimer.a(this.a, l);
          break;
          SSCMTimer.b(this.a, SSCMTimer.a(this.a));
        } while (SSCMTimer.b(this.a) < 120000);
        SSCMTimer.c(this.a, 1);
        cancel();
      } while (SSCMTimer.a(this.a) == null);
      SSCMTimer.a(this.a).b(SSCMTimer.a(this.a));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icb
 * JD-Core Version:    0.7.0.1
 */