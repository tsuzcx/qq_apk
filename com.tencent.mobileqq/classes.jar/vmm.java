import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class vmm
  implements DialogInterface.OnCancelListener
{
  public vmm(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FollowCaptureLauncher.a(this.a, true);
    FollowCaptureLauncher.a(this.a);
    FollowCaptureLauncher.a(this.a, false);
    wxj.a("FollowLaunchCancel", true, System.currentTimeMillis() - FollowCaptureLauncher.a(this.a), new String[] { "dialog_cancel" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */