import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;

public class bst
  implements View.OnLongClickListener
{
  public bst(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    Object localObject = (ChatActivity)paramView.getContext();
    String str = (String)paramView.getTag(2131296298);
    paramView = (ChatMessage)paramView.getTag();
    if (paramView != null)
    {
      localObject = ((ChatActivity)localObject).a();
      if (!(localObject instanceof TroopChatPie)) {
        break label124;
      }
      if (((TroopChatPie)localObject).a(paramView.senderuin, str, false)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      }
    }
    for (;;)
    {
      return true;
      label124:
      if ((localObject instanceof DiscussChatPie)) {
        ((DiscussChatPie)localObject).a(paramView.senderuin, str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bst
 * JD-Core Version:    0.7.0.1
 */