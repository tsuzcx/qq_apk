import com.tencent.mobileqq.app.GuardManager;
import java.util.TimerTask;

public class fcr
  extends TimerTask
{
  private fcr(GuardManager paramGuardManager) {}
  
  public void run()
  {
    if (GuardManager.b(this.a)) {
      GuardManager.a(this.a).a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcr
 * JD-Core Version:    0.7.0.1
 */