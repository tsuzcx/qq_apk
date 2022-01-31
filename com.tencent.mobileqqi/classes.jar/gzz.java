import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class gzz
  extends TimerTask
{
  public gzz(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new haa(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzz
 * JD-Core Version:    0.7.0.1
 */