import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.statistics.ReportTask;

public class wiw
  implements View.OnClickListener
{
  public wiw(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.notifyDataSetChanged();
    int i = ContactsTroopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter, this.jdField_a_of_type_Int);
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wiw
 * JD-Core Version:    0.7.0.1
 */