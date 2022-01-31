import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class gvr
  implements DialogInterface.OnDismissListener
{
  public gvr(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvr
 * JD-Core Version:    0.7.0.1
 */