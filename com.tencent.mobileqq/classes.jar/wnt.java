import com.tencent.mobileqq.activity.contacts.adapter.PhoneContactAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.widget.XListView;

class wnt
  implements Runnable
{
  wnt(wns paramwns, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      PhoneContactFragment.a(this.jdField_a_of_type_Wns.a, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter == null)
      {
        this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter = new PhoneContactAdapter(this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentWidgetXListView, 1, true, this.jdField_a_of_type_Wns.a);
        this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter);
      }
      this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter.a(this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Wns.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnt
 * JD-Core Version:    0.7.0.1
 */