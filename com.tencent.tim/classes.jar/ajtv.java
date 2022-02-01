import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajtv
  implements View.OnClickListener
{
  public ajtv(RecentUserInvitePanel paramRecentUserInvitePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.a.hj(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtv
 * JD-Core Version:    0.7.0.1
 */