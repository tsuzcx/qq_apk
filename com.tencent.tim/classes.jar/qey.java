import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class qey
  implements DialogInterface.OnCancelListener
{
  public qey(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FollowCaptureLauncher.a(this.this$0, true);
    FollowCaptureLauncher.a(this.this$0);
    FollowCaptureLauncher.a(this.this$0, false);
    rar.a("FollowLaunchCancel", true, System.currentTimeMillis() - FollowCaptureLauncher.a(this.this$0), new String[] { "dialog_cancel" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qey
 * JD-Core Version:    0.7.0.1
 */