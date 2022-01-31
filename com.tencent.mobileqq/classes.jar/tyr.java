import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class tyr
  implements DialogInterface.OnClickListener
{
  public tyr(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyr
 * JD-Core Version:    0.7.0.1
 */