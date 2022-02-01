import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akwr
  implements DialogInterface.OnClickListener
{
  akwr(akwp paramakwp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwr
 * JD-Core Version:    0.7.0.1
 */