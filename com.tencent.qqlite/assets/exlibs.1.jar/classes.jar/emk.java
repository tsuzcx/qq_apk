import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class emk
  extends TimerTask
{
  public emk(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new eml(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     emk
 * JD-Core Version:    0.7.0.1
 */