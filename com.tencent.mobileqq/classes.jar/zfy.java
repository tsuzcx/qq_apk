import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;

public class zfy
  implements Runnable
{
  public zfy(LebaHelper paramLebaHelper) {}
  
  public void run()
  {
    LebaHelper.c(this.a);
    LebaHelper.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker = new CampusLebaEntryChecker(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker = new WholePeopleLebaEntryChecker(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    LebaHelper.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfy
 * JD-Core Version:    0.7.0.1
 */