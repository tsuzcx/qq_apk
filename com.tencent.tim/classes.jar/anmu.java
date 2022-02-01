import android.app.Activity;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import mqq.app.QQPermissionCallback;

public final class anmu
  implements QQPermissionCallback
{
  public anmu(CheckPermission.a parama, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.val$activity, this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.bK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */