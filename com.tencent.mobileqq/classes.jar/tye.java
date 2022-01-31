import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class tye
  implements DialogInterface.OnDismissListener
{
  public tye(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.postDelayed(new tzg(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */