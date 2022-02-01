import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class anmv
  implements QQPermissionCallback
{
  public anmv(CheckPermission.a parama, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.b, this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.bK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmv
 * JD-Core Version:    0.7.0.1
 */