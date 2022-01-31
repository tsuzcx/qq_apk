import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;

public class wxp
  implements DialogInterface.OnClickListener
{
  public wxp(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxp
 * JD-Core Version:    0.7.0.1
 */