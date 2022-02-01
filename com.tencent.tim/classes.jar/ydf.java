import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

class ydf
  implements kaw.b
{
  ydf(ycd paramycd) {}
  
  public void aB(boolean paramBoolean)
  {
    this.this$0.aAt();
    if (!paramBoolean)
    {
      this.this$0.oh(2131697432);
      return;
    }
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localEntityManager.find(AccountDetail.class, this.this$0.sessionInfo.aTl);
    if (localAccountDetail != null) {
      localEntityManager.remove(localAccountDetail);
    }
    localEntityManager.close();
    this.this$0.app.b().N(this.this$0.sessionInfo.aTl, 1008);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydf
 * JD-Core Version:    0.7.0.1
 */