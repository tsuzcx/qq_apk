import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;

public class anmq
  implements DialogInterface.OnClickListener
{
  public anmq(CheckPermission paramCheckPermission) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.b.checkPermission(CheckPermission.access$000(this.b)))
      {
        CheckPermission.access$002(this.b, null);
        this.b.mDirector.dRE();
      }
      return;
    }
    CheckPermission.access$000(this.b).superFinish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */