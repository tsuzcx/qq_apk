import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class vzh
  implements DialogInterface.OnDismissListener
{
  public vzh(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.this$0.Z) {
      this.this$0.Z = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzh
 * JD-Core Version:    0.7.0.1
 */