import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ContactUtils;

public class ukc
  implements View.OnLongClickListener
{
  public ukc(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    String str;
    do
    {
      do
      {
        return false;
        localObject = (FragmentActivity)paramView.getContext();
        str = (String)paramView.getTag(2131361863);
        paramView = (ChatMessage)paramView.getTag();
        if (paramView == null) {
          break;
        }
        localObject = ((FragmentActivity)localObject).getChatFragment();
      } while (localObject == null);
      localObject = ((ChatFragment)localObject).a();
    } while (localObject == null);
    if ((localObject instanceof HotChatPie))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      HotChatInfo localHotChatInfo = localHotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom)) {
        return true;
      }
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
      if ((localHotChatInfo != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) || (((localHotChatInfo.isOwnerOrAdmin(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (localHotChatManager.b())) && (!localHotChatInfo.isOwnerOrAdmin(paramView.senderuin)) && ((!localHotChatInfo.isRobotHotChat) || (!localTroopRobotManager.b(paramView.senderuin)))))) {
        ((HotChatPie)localObject).a(paramView, str);
      }
    }
    for (;;)
    {
      return true;
      ((HotChatPie)localObject).a(paramView.senderuin, str, false, 1);
      continue;
      if ((localObject instanceof TroopChatPie))
      {
        ((TroopChatPie)localObject).a(paramView.senderuin, str, false, 1);
      }
      else if ((localObject instanceof DiscussChatPie))
      {
        if (ContactUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin)) {
          return true;
        }
        ((DiscussChatPie)localObject).a(paramView.senderuin, str, false);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */