import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class bcm
  implements Runnable
{
  public bcm(QQLSActivity paramQQLSActivity, Object paramObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.isFinishing()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS is finish but still update");
      }
    }
    label182:
    do
    {
      ChatMessage localChatMessage;
      RoamSettingController localRoamSettingController;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof NewFriendMessage))) {
                    break label182;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "data is NewFriendMessage" + Thread.currentThread().getId());
                  }
                  if (((NewFriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(31)).a() != 0) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
                return;
              } while ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getText())));
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), AppConstants.V, 4000);
              QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              QQLSActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              return;
              if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ChatMessage))) {
                break;
              }
            } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_JavaLangObject == null));
            QLog.d("QQLSActivity", 2, "update data is not chatMessage return" + this.jdField_a_of_type_JavaLangObject.getClass());
            return;
            localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaLangObject;
          } while ((localChatMessage.isSend()) || (localChatMessage.istroop == 6000) || (localChatMessage.istroop == 1009));
          if (localChatMessage.istroop != 1) {
            break;
          }
        } while (((FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8)).f(localChatMessage.frienduin));
        localRoamSettingController = (RoamSettingController)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(28);
      } while ((localRoamSettingController != null) && (localRoamSettingController.a(localChatMessage.frienduin, 1) != 1));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localChatMessage.frienduin, localChatMessage.istroop);
    } while ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getText())));
    QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcm
 * JD-Core Version:    0.7.0.1
 */