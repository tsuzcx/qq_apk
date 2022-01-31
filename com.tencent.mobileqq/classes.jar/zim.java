import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zim
  implements Runnable
{
  public zim(PhoneContactManagerImp paramPhoneContactManagerImp, long paramLong) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).iterator();
      if (localIterator.hasNext()) {
        ((PhoneContactManager.IPhoneContactListener)localIterator.next()).a(this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zim
 * JD-Core Version:    0.7.0.1
 */