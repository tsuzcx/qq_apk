import com.tencent.device.msg.activities.DeviceTipActivity;
import mqq.app.QQPermissionCallback;

public class zxp
  implements QQPermissionCallback
{
  public zxp(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceTipActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxp
 * JD-Core Version:    0.7.0.1
 */