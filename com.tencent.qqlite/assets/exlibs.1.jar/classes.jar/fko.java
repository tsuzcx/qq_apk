import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class fko
  implements DialogInterface.OnClickListener
{
  public fko(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fko
 * JD-Core Version:    0.7.0.1
 */