import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchDialogDismissRunnable;

public class wbu
  implements DialogInterface.OnDismissListener
{
  public wbu(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.mHandler.postDelayed(new TroopMemberListActivity.SearchDialogDismissRunnable(this.this$0), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbu
 * JD-Core Version:    0.7.0.1
 */