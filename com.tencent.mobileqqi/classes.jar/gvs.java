import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class gvs
  extends TimerTask
{
  public gvs(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new gvt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvs
 * JD-Core Version:    0.7.0.1
 */