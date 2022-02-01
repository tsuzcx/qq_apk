import com.tencent.mobileqq.app.GuardManager;
import java.util.TimerTask;

public class fcq
  extends TimerTask
{
  private fcq(GuardManager paramGuardManager) {}
  
  public void run()
  {
    if (GuardManager.b(this.a)) {
      GuardManager.a(this.a).a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcq
 * JD-Core Version:    0.7.0.1
 */