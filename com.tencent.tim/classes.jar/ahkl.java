import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahkl
  implements DialogInterface.OnClickListener
{
  ahkl(ahki paramahki) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "handleSDForImageShare dismiss Exception:", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkl
 * JD-Core Version:    0.7.0.1
 */