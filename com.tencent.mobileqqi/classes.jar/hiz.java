import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class hiz
  implements AdapterView.OnItemClickListener
{
  public hiz(FriendChooser paramFriendChooser) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((paramAdapterView == null) || (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a))) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.a.d)
    {
      this.a.l();
      return;
    }
    paramView = (OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    this.a.b.add(paramAdapterView);
    this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a);
    this.a.i();
    paramView.g();
    this.a.b(true);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hiz
 * JD-Core Version:    0.7.0.1
 */