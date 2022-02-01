import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yrf
  implements View.OnClickListener
{
  public yrf(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrf
 * JD-Core Version:    0.7.0.1
 */