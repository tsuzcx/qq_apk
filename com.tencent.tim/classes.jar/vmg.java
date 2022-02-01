import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class vmg
  implements QQPermissionCallback
{
  public vmg(ProfileCardMoreActivity paramProfileCardMoreActivity1, ProfileCardMoreActivity paramProfileCardMoreActivity2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions denied...");
    aqha.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions grant...");
    this.this$0.bSB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmg
 * JD-Core Version:    0.7.0.1
 */