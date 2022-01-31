import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.Login;

public class fgn
  implements DialogInterface.OnClickListener
{
  public fgn(Login paramLogin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgn
 * JD-Core Version:    0.7.0.1
 */