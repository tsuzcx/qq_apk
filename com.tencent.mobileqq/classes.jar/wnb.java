import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;

public class wnb
  implements Runnable
{
  public wnb(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnb
 * JD-Core Version:    0.7.0.1
 */