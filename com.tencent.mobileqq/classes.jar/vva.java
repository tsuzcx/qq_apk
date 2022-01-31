import com.tencent.biz.pubaccount.PublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class vva
  implements PublicAccountManager.refuseAcceptDone
{
  public vva(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.aY();
    if (!paramBoolean)
    {
      this.a.w(2131430016);
      return;
    }
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localEntityManager.a(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localEntityManager.b(localAccountDetail);
    }
    localEntityManager.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vva
 * JD-Core Version:    0.7.0.1
 */