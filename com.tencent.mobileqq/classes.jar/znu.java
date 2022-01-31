import com.tencent.device.bind.DevicePluginDownloadActivity;
import mqq.app.QQPermissionCallback;

public class znu
  implements QQPermissionCallback
{
  public znu(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DevicePluginDownloadActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     znu
 * JD-Core Version:    0.7.0.1
 */