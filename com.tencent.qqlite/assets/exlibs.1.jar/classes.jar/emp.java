import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class emp
  extends TimerTask
{
  public emp(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new emq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     emp
 * JD-Core Version:    0.7.0.1
 */