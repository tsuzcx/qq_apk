import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class eod
  implements DialogInterface.OnDismissListener
{
  public eod(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eod
 * JD-Core Version:    0.7.0.1
 */