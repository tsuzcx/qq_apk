import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Vector;

public class feo
  implements Runnable
{
  public feo(PhoneContactManagerImp paramPhoneContactManagerImp, String paramString) {}
  
  public void run()
  {
    Entity localEntity = PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(RecommendContact.class, this.jdField_a_of_type_JavaLangString);
    if (localEntity != null)
    {
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).b(localEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a.remove(localEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     feo
 * JD-Core Version:    0.7.0.1
 */