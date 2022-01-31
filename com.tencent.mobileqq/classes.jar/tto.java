import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class tto
  implements DialogInterface.OnCancelListener
{
  public tto(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FollowCaptureLauncher.a(this.a, true);
    FollowCaptureLauncher.a(this.a);
    FollowCaptureLauncher.a(this.a, false);
    vel.a("FollowLaunchCancel", true, System.currentTimeMillis() - FollowCaptureLauncher.a(this.a), new String[] { "dialog_cancel" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tto
 * JD-Core Version:    0.7.0.1
 */