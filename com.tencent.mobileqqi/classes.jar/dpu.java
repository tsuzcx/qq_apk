import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class dpu
  implements DialogInterface.OnDismissListener
{
  public dpu(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpu
 * JD-Core Version:    0.7.0.1
 */