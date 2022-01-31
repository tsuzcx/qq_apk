import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class aoe
  extends Handler
{
  public aoe(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (paramMessage.what == 2)
    {
      this.a.a();
      return;
    }
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break;
      }
      this.a.a(localObject2, (String)localObject1);
      return;
      if ((paramMessage.obj instanceof String))
      {
        localObject1 = (String)paramMessage.obj;
        continue;
        if (paramMessage.what == 4)
        {
          if (paramMessage.arg1 == 1) {}
          for (boolean bool = true;; bool = false)
          {
            if (!(paramMessage.obj instanceof Card)) {
              break label235;
            }
            localObject1 = (Card)paramMessage.obj;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
            this.a.a((Card)localObject1, bool);
            if (paramMessage.arg2 != 1) {
              break;
            }
            FriendProfileCardActivity.b(this.a).setEnabled(FriendProfileCardActivity.a(this.a));
            return;
          }
          label235:
          if (!(paramMessage.obj instanceof ContactCard)) {
            break;
          }
          paramMessage = (ContactCard)paramMessage.obj;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramMessage;
          this.a.a(paramMessage, bool);
          return;
        }
        if (paramMessage.what == 8)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_INITED");
          }
          FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        }
        if (paramMessage.what == 9)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_INITED_FAIL");
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
          FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        }
        if (paramMessage.what == 6)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_DOWNLOAD_SUCCESS");
          }
          FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        }
        if (paramMessage.what == 7)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_DOWNLOAD_FAIL");
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
          FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        }
        if (paramMessage.what == 10)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Boolean = true;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
          return;
        }
        if ((paramMessage.what != 11) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aoe
 * JD-Core Version:    0.7.0.1
 */