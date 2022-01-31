import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class cbl
  implements Runnable
{
  public cbl(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    new cbm(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbl
 * JD-Core Version:    0.7.0.1
 */