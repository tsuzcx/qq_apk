import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class fer
  implements Runnable
{
  public fer(PhoneContactManagerImp paramPhoneContactManagerImp, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "setRecommendMsgReaded");
    }
    EntityTransaction localEntityTransaction = PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a();
    try
    {
      localEntityTransaction.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecommendContact localRecommendContact = (RecommendContact)localIterator.next();
        PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(localRecommendContact);
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fer
 * JD-Core Version:    0.7.0.1
 */