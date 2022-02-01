import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import mqq.app.QQPermissionCallback;

public class zpi
  implements QQPermissionCallback
{
  public zpi(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AvatarPendantActivity.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpi
 * JD-Core Version:    0.7.0.1
 */