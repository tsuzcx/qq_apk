import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.AuthorityActivity;

public class fak
  implements DialogInterface.OnClickListener
{
  public fak(AuthorityActivity paramAuthorityActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fak
 * JD-Core Version:    0.7.0.1
 */