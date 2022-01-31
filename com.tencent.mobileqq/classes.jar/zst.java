import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import mqq.app.QQPermissionCallback;

public class zst
  implements QQPermissionCallback
{
  public zst(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zst
 * JD-Core Version:    0.7.0.1
 */