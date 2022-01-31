import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;

public class wjw
  implements Runnable
{
  public wjw(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */