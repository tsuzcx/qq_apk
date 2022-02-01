import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class avgm
  implements DialogInterface.OnClickListener
{
  avgm(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$cancelListener.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgm
 * JD-Core Version:    0.7.0.1
 */