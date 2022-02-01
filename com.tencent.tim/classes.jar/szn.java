import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import mqq.app.QQPermissionCallback;

public class szn
  implements QQPermissionCallback
{
  public szn(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szn
 * JD-Core Version:    0.7.0.1
 */