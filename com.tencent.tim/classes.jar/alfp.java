import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class alfp
  implements DialogInterface.OnClickListener
{
  alfp(alfl paramalfl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    alfl.a(this.b, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfp
 * JD-Core Version:    0.7.0.1
 */