import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class zmb
  implements Runnable
{
  public zmb(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localEntityManager == null) {}
      for (;;)
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label89;
        }
        localEntityManager = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getEntityManagerFactory().createEntityManager();
        break;
        if (this.jdField_a_of_type_Int == 2) {}
        for (Entity localEntity = localEntityManager.a(NotificationRecommendTroopItem.class, this.jdField_a_of_type_JavaLangString); localEntity != null; localEntity = null)
        {
          localEntityManager.b(localEntity);
          return;
        }
      }
      label89:
      localEntityManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmb
 * JD-Core Version:    0.7.0.1
 */