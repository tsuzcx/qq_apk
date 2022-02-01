import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ukm
  implements DialogInterface.OnClickListener
{
  ukm(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.onClick(paramDialogInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukm
 * JD-Core Version:    0.7.0.1
 */