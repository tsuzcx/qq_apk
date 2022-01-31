import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class chn
  implements DialogInterface.OnClickListener
{
  public chn(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chn
 * JD-Core Version:    0.7.0.1
 */