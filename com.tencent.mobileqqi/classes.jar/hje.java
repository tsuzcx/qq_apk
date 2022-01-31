import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.FriendListOpenFrame.FriendListAdapter;

public class hje
  extends Handler
{
  public hje(FriendListOpenFrame paramFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame$FriendListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hje
 * JD-Core Version:    0.7.0.1
 */