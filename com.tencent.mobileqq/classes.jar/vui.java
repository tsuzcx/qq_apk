import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vui
  implements Runnable
{
  public vui(PublicAccountChatPie paramPublicAccountChatPie, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateUnfollowInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.V)
    {
      int i = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    PublicAccountChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).post(new vuj(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */