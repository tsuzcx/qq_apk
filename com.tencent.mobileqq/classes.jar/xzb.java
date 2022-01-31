import com.tencent.device.bind.DevicePluginDownloadActivity;
import mqq.app.QQPermissionCallback;

public class xzb
  implements QQPermissionCallback
{
  public xzb(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DevicePluginDownloadActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xzb
 * JD-Core Version:    0.7.0.1
 */