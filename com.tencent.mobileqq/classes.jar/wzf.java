import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter;

public class wzf
  implements Runnable
{
  public wzf(TroopUnAccalimedRedPacketList.HbListAdapter paramHbListAdapter) {}
  
  public void run()
  {
    if (TroopUnAccalimedRedPacketList.a() != null) {
      TroopUnAccalimedRedPacketList.a().invalidateItemDecorations();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzf
 * JD-Core Version:    0.7.0.1
 */