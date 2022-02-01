import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class xfy
  implements DialogInterface.OnCancelListener
{
  public xfy(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FollowCaptureLauncher.a(this.a, true);
    FollowCaptureLauncher.a(this.a);
    FollowCaptureLauncher.a(this.a, false);
    yqu.a("FollowLaunchCancel", true, System.currentTimeMillis() - FollowCaptureLauncher.a(this.a), new String[] { "dialog_cancel" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */