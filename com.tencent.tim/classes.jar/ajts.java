import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajts
  implements View.OnClickListener
{
  public ajts(PlayerInvitePanel paramPlayerInvitePanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PlayerInvitePanel.a(this.b) != null) {
      PlayerInvitePanel.a(this.b).onItemClick(this.b, paramView, this.bHc, this.bHc);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajts
 * JD-Core Version:    0.7.0.1
 */