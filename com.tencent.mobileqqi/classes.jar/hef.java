import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class hef
  implements DialogInterface.OnDismissListener
{
  public hef(TroopShareUtility paramTroopShareUtility) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TroopShareUtility.b(this.a, false);
    if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hef
 * JD-Core Version:    0.7.0.1
 */