import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import java.util.ArrayList;

public class fbg
  implements AdapterView.OnItemClickListener
{
  public fbg(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.getItem(paramInt);
    if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a))
    {
      this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b(paramAdapterView.a);
      this.a.b.remove(paramAdapterView);
      this.a.g();
      ((OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbg
 * JD-Core Version:    0.7.0.1
 */