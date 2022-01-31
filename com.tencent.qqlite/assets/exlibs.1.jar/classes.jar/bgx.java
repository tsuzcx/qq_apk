import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;

public class bgx
  implements DialogInterface.OnClickListener
{
  public bgx(RegisterActivity paramRegisterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgx
 * JD-Core Version:    0.7.0.1
 */