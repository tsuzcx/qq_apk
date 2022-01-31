import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class fam
  implements DialogInterface.OnClickListener
{
  public fam(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fam
 * JD-Core Version:    0.7.0.1
 */