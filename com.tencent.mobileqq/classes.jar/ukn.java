import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ukn
  implements DialogInterface.OnClickListener
{
  ukn(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.onClick(paramDialogInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukn
 * JD-Core Version:    0.7.0.1
 */