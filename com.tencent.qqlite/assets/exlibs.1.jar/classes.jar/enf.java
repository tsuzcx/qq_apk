import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;

public class enf
  implements DialogInterface.OnDismissListener
{
  public enf(TroopLocationModifyActivity paramTroopLocationModifyActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.b) {
      this.a.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     enf
 * JD-Core Version:    0.7.0.1
 */