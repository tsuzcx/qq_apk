import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class dfz
  implements DialogInterface.OnClickListener
{
  public dfz(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfz
 * JD-Core Version:    0.7.0.1
 */