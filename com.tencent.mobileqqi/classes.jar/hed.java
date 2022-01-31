import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class hed
  implements DialogInterface.OnDismissListener
{
  public hed(TroopShareUtility paramTroopShareUtility) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TroopShareUtility.a(this.a, false);
    if ((!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) || (this.a.a)) {
      return;
    }
    ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hed
 * JD-Core Version:    0.7.0.1
 */