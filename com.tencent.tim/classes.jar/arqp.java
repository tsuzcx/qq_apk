import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.FriendChooser.a;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arqp
  implements AdapterView.OnItemClickListener
{
  public arqp(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Friend localFriend = (Friend)this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser$a.getItem(paramInt);
    if ((localFriend != null) && (this.a.jdField_a_of_type_Artl.so(localFriend.openId)))
    {
      this.a.jdField_a_of_type_Artl.Xa(localFriend.openId);
      this.a.aQ.remove(localFriend);
      this.a.cAc();
      ((OpenFrame)this.a.b.getCurrentView()).notifyDataSetChanged();
      this.a.cz(false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqp
 * JD-Core Version:    0.7.0.1
 */