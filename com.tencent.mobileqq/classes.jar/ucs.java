import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ucs
  implements Runnable
{
  public ucs(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = TroopInfoActivity.a(this.a, this.a.a);
    if (localArrayList != null) {
      ThreadManager.getUIHandler().post(new uct(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucs
 * JD-Core Version:    0.7.0.1
 */