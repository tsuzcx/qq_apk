import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class vid
  implements DialogInterface.OnCancelListener
{
  public vid(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FollowCaptureLauncher.a(this.a, true);
    FollowCaptureLauncher.a(this.a);
    FollowCaptureLauncher.a(this.a, false);
    wta.a("FollowLaunchCancel", true, System.currentTimeMillis() - FollowCaptureLauncher.a(this.a), new String[] { "dialog_cancel" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */