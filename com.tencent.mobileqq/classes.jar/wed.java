import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.FormMutiItem;

class wed
  implements Runnable
{
  wed(wec paramwec) {}
  
  public void run()
  {
    String str2 = this.a.jdField_a_of_type_JavaLangStringBuilder.toString();
    String str1 = str2;
    if (str2.endsWith("、")) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a != null)
    {
      if (!str1.equals("条件："))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a.setSecondLineVisible(true);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a.setSecondLineText(str1);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a.setSecondLineVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wed
 * JD-Core Version:    0.7.0.1
 */