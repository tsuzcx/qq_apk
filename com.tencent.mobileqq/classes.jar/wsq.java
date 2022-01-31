import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import java.util.ArrayList;

public class wsq
  extends SmartDeviceObserver
{
  public wsq(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList paramArrayList)
  {
    if (this.a.e)
    {
      this.a.e = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener.a(2, true, null);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.a = ((ArrayList)paramArrayList.clone());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDeviceAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */