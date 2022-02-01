import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.contacts.device.DeviceFragment;
import java.util.ArrayList;

public class zal
  extends syv
{
  public zal(DeviceFragment paramDeviceFragment) {}
  
  protected void h(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.this$0.aUE)
    {
      this.this$0.aUE = false;
      if (DeviceFragment.a(this.this$0) != null) {
        DeviceFragment.b(this.this$0).d(this.this$0.xZ(), true, null);
      }
    }
    if (this.this$0.a == null) {
      return;
    }
    this.this$0.a.rr = ((ArrayList)paramArrayList.clone());
    this.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */