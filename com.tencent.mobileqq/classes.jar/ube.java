import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class ube
  implements DialogInterface.OnDismissListener
{
  public ube(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.postDelayed(new ucg(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ube
 * JD-Core Version:    0.7.0.1
 */