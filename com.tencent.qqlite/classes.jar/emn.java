import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;

public class emn
  implements Runnable
{
  public emn(TroopFeedsDataManager paramTroopFeedsDataManager) {}
  
  public void run()
  {
    Message localMessage = this.a.a.obtainMessage(2);
    localMessage.obj = this.a.a();
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     emn
 * JD-Core Version:    0.7.0.1
 */