import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aciw
  implements DialogInterface.OnClickListener
{
  aciw(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aciu.Ew("1");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.val$okListener != null) {
      this.val$okListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aciw
 * JD-Core Version:    0.7.0.1
 */