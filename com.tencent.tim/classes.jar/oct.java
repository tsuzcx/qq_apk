import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.util.ProfileParams;

final class oct
  implements DialogInterface.OnCancelListener
{
  oct(Activity paramActivity, ProfileParams paramProfileParams) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
    {
      ahkr.a(this.val$activity, true, "shareToQzone", Long.valueOf(this.c.la()).longValue());
      this.val$activity.setResult(0);
      this.val$activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oct
 * JD-Core Version:    0.7.0.1
 */