import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;

public class wiq
  implements DialogInterface.OnClickListener
{
  public wiq(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wiq
 * JD-Core Version:    0.7.0.1
 */