import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public final class gxl
  implements Runnable
{
  public gxl(QQAppInterface paramQQAppInterface, Entity paramEntity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity.getId() != -1L)) {
      if (!localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity)) {
        localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity.getClass());
      }
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxl
 * JD-Core Version:    0.7.0.1
 */