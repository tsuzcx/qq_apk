import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.SetPermission;
import java.io.PrintStream;
import mqq.app.permission.PermissionCallback;

public class gkd
  implements PermissionCallback
{
  public gkd(SetPermission paramSetPermission) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(SetPermission.a(this.a), paramInt, paramArrayOfString, new gke(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 100) {
      this.a.a.b();
    }
    for (;;)
    {
      System.out.println("success  +++++++++++++++++++++++++++++++");
      return;
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gkd
 * JD-Core Version:    0.7.0.1
 */