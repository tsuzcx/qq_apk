import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;

public class wsn
  extends MessageObserver
{
  public wsn(DeviceFragment paramDeviceFragment) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceFragment.c = bool;
      this.a.a.c();
      this.a.a.notifyDataSetChanged();
      return;
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceFragment.d = bool;
      this.a.a.d();
      this.a.a.a(this.a.d, AppConstants.z);
      this.a.a.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */