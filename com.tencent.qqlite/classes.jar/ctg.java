import com.tencent.mobileqq.app.GuardManager;
import java.util.TimerTask;

public class ctg
  extends TimerTask
{
  private ctg(GuardManager paramGuardManager) {}
  
  public void run()
  {
    if (GuardManager.b(this.a)) {
      this.a.b(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ctg
 * JD-Core Version:    0.7.0.1
 */