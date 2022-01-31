import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;

public class gul
  implements DialogInterface.OnDismissListener
{
  public gul(TroopLocationModifyActivity paramTroopLocationModifyActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.b) {
      this.a.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gul
 * JD-Core Version:    0.7.0.1
 */