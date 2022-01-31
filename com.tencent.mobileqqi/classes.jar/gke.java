import android.os.Process;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.startup.step.SetPermission;
import mqq.app.AppActivity;

class gke
  implements PermissionDialogCallback
{
  gke(gkd paramgkd) {}
  
  public void a()
  {
    SetPermission.a(this.a.a).superFinish();
    Process.killProcess(Process.myPid());
  }
  
  public void b()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gke
 * JD-Core Version:    0.7.0.1
 */