import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class atb
  implements DialogInterface.OnClickListener
{
  public atb(LoginActivity paramLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atb
 * JD-Core Version:    0.7.0.1
 */