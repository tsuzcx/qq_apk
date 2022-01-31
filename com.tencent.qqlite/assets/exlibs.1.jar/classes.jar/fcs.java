import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class fcs
  implements DialogInterface.OnClickListener
{
  fcs(fcp paramfcp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fcs
 * JD-Core Version:    0.7.0.1
 */