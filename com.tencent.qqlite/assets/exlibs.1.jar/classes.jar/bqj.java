import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;

public class bqj
  implements Runnable
{
  public bqj(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqj
 * JD-Core Version:    0.7.0.1
 */