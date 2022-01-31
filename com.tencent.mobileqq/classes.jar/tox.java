import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;

public class tox
  implements DialogInterface.OnClickListener
{
  public tox(RegisterActivity paramRegisterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tox
 * JD-Core Version:    0.7.0.1
 */