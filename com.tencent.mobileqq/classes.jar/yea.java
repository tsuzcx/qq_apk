import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import mqq.app.QQPermissionCallback;

public class yea
  implements QQPermissionCallback
{
  public yea(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yea
 * JD-Core Version:    0.7.0.1
 */