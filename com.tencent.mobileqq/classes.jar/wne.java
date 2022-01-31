import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import com.tencent.mobileqq.app.FriendListObserver;

public class wne
  extends FriendListObserver
{
  public wne(DeviceFragment paramDeviceFragment) {}
  
  protected void onPullIpad()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.d();
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wne
 * JD-Core Version:    0.7.0.1
 */