import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class erl
  implements DialogInterface.OnDismissListener
{
  public erl(TroopShareUtility paramTroopShareUtility) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TroopShareUtility.b(this.a, false);
    if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erl
 * JD-Core Version:    0.7.0.1
 */