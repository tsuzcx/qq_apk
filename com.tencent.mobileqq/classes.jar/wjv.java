import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import com.tencent.widget.XListView;

public class wjv
  implements Runnable
{
  public wjv(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a();
      if ((i >= 0) && (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.getCount())) {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjv
 * JD-Core Version:    0.7.0.1
 */