import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Map;

public class bkj
  implements Runnable
{
  public bkj(PublicAccountManager paramPublicAccountManager, QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    PublicAccountMenuEntity localPublicAccountMenuEntity1 = new PublicAccountMenuEntity(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse, this.jdField_a_of_type_Long);
    if (((EntityManager)localObject).a(PublicAccountMenuEntity.class, this.jdField_a_of_type_JavaLangString) != null)
    {
      PublicAccountMenuEntity localPublicAccountMenuEntity2 = (PublicAccountMenuEntity)((EntityManager)localObject).a(PublicAccountMenuEntity.class, this.jdField_a_of_type_JavaLangString);
      if (localPublicAccountMenuEntity2 != null)
      {
        localPublicAccountMenuEntity2.clone(localPublicAccountMenuEntity1);
        ((EntityManager)localObject).a(localPublicAccountMenuEntity2);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse.button_info.get();
      long l = localPublicAccountMenuEntity1.savedDateTime;
      PublicAccountManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager).put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l));
      PublicAccountManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager).put(this.jdField_a_of_type_JavaLangString, localObject);
      return;
      ((EntityManager)localObject).a(localPublicAccountMenuEntity1);
      continue;
      ((EntityManager)localObject).a(localPublicAccountMenuEntity1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkj
 * JD-Core Version:    0.7.0.1
 */