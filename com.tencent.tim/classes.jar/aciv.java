import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aciv
  implements DialogInterface.OnClickListener
{
  aciv(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.H != null) {
      this.H.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aciv
 * JD-Core Version:    0.7.0.1
 */