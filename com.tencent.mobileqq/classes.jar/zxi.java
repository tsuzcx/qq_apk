import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import mqq.app.QQPermissionCallback;

public class zxi
  implements QQPermissionCallback
{
  public zxi(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxi
 * JD-Core Version:    0.7.0.1
 */