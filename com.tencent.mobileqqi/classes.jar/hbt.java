import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;

public final class hbt
  implements Runnable
{
  public hbt(QQAppInterface paramQQAppInterface, List paramList) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localEntityManager.a((Entity)localIterator.next());
    }
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hbt
 * JD-Core Version:    0.7.0.1
 */