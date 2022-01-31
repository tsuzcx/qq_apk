import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.persistence.EntityManager;

public class zuv
  implements Runnable
{
  public zuv(DataLineMsgProxy paramDataLineMsgProxy, EntityManager paramEntityManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("create index if not exists " + this.jdField_a_of_type_JavaLangString + "_index ON " + this.jdField_a_of_type_JavaLangString + "(groupId, msgId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zuv
 * JD-Core Version:    0.7.0.1
 */