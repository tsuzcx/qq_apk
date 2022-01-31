import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter;

public class xck
  implements Runnable
{
  public xck(TroopUnAccalimedRedPacketList.HbListAdapter paramHbListAdapter) {}
  
  public void run()
  {
    if (TroopUnAccalimedRedPacketList.a() != null) {
      TroopUnAccalimedRedPacketList.a().invalidateItemDecorations();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xck
 * JD-Core Version:    0.7.0.1
 */