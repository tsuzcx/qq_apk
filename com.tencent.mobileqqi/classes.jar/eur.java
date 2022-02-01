import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class eur
  implements DialogInterface.OnClickListener
{
  public eur(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eur
 * JD-Core Version:    0.7.0.1
 */