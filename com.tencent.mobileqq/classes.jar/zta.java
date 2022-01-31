import com.tencent.device.msg.activities.DeviceTipActivity;
import mqq.app.QQPermissionCallback;

public class zta
  implements QQPermissionCallback
{
  public zta(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceTipActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zta
 * JD-Core Version:    0.7.0.1
 */