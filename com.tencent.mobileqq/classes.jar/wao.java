import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import java.util.Set;

public class wao
  implements Runnable
{
  public wao(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TroopRemindSettingManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.a.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433353));
      this.a.jdField_a_of_type_AndroidWidgetToast.show();
      TroopRemindSettingManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((localObject != null) && (((DiscussionManager)localObject).a.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((DiscussionManager)localObject).a.remove(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (TroopAppMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      if (this.a.m != ((TroopAppMgr)localObject).a(0))
      {
        this.a.m = ((TroopAppMgr)localObject).a(0);
        this.a.b.sendEmptyMessage(4);
      }
      ((TroopAppMgr)localObject).a(true, localTroopManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      ((TroopAppMgr)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wao
 * JD-Core Version:    0.7.0.1
 */