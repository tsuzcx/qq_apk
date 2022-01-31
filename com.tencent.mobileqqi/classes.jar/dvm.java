import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class dvm
  implements DialogInterface.OnDismissListener
{
  public dvm(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvm
 * JD-Core Version:    0.7.0.1
 */