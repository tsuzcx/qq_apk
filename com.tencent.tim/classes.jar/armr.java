import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class armr
  implements DialogInterface.OnClickListener
{
  armr(armm.a parama, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.callback(2);
    paramDialogInterface.dismiss();
    if (this.val$scene == 1) {
      armm.iF("0X80094F8");
    }
    do
    {
      return;
      if ((this.val$scene == 2) || (this.val$scene == 4) || (this.val$scene == 5))
      {
        armm.iF("0X80094F7");
        return;
      }
    } while (this.val$scene != 3);
    armm.iF("0X80094F9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armr
 * JD-Core Version:    0.7.0.1
 */