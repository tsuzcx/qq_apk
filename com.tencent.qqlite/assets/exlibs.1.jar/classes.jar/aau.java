import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.ExtensionInfo;

public class aau
  implements Runnable
{
  public aau(BaseChatPie paramBaseChatPie, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie) != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidOsHandler.obtainMessage(33, localExtensionInfo.audioPanelType, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aau
 * JD-Core Version:    0.7.0.1
 */