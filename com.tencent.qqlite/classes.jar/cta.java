import com.tencent.mobileqq.app.GuardManager;
import java.util.TimerTask;

public class cta
  extends TimerTask
{
  private cta(GuardManager paramGuardManager) {}
  
  public void run()
  {
    if (GuardManager.b(this.a)) {
      this.a.b(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cta
 * JD-Core Version:    0.7.0.1
 */