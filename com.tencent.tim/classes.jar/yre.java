import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.widget.SwipListView.a;

public class yre
  implements SwipListView.a
{
  public yre(ConnectionsExplorationClidFragment paramConnectionsExplorationClidFragment) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).L(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).L(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yre
 * JD-Core Version:    0.7.0.1
 */