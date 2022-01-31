import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import com.tencent.mobileqq.app.DataLineObserver;

public class wjy
  extends DataLineObserver
{
  public wjy(DeviceFragment paramDeviceFragment) {}
  
  protected void b()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.c();
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjy
 * JD-Core Version:    0.7.0.1
 */