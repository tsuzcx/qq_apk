import com.tencent.device.msg.activities.DeviceTipActivity;
import mqq.app.QQPermissionCallback;

public class yeh
  implements QQPermissionCallback
{
  public yeh(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceTipActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */