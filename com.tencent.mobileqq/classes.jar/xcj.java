import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetAvailableListListener;
import java.util.List;

public class xcj
  implements IRedPacket.OnGetAvailableListListener
{
  public xcj(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void OnGetAvailableList(List paramList)
  {
    if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
      TroopUnAccalimedRedPacketList.a(this.a).setVisibility(8);
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      TroopUnAccalimedRedPacketList.a().setVisibility(8);
      TroopUnAccalimedRedPacketList.a().setVisibility(0);
      TroopUnAccalimedRedPacketList.a().setText("暂无未领红包");
    }
    do
    {
      return;
      TroopUnAccalimedRedPacketList.a().setVisibility(0);
      TroopUnAccalimedRedPacketList.a().setVisibility(8);
      TroopUnAccalimedRedPacketList.a().a(paramList);
    } while (TroopUnAccalimedRedPacketList.a(this.a) == null);
    TroopUnAccalimedRedPacketList.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcj
 * JD-Core Version:    0.7.0.1
 */