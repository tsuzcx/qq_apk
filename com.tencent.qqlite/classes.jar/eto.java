import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class eto
  implements DialogInterface.OnDismissListener
{
  public eto(TroopShareUtility paramTroopShareUtility) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TroopShareUtility.a(this.a, false);
    if ((!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) || (this.a.a)) {
      return;
    }
    ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eto
 * JD-Core Version:    0.7.0.1
 */