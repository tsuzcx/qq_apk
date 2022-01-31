import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class cak
  implements Runnable
{
  public cak(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    new cal(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cak
 * JD-Core Version:    0.7.0.1
 */