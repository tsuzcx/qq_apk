import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import java.util.List;

public class zqa
  implements Runnable
{
  public zqa(PhoneContactManagerImp paramPhoneContactManagerImp, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a = ContactBindedAdapter.a(this.jdField_a_of_type_JavaUtilList, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqa
 * JD-Core Version:    0.7.0.1
 */