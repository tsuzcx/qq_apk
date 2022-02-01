import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class ayui
  implements DialogInterface.OnClickListener
{
  ayui(ayuf paramayuf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((ayub)this.b.b).ZO(false);
    ayuf.a(this.b).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayui
 * JD-Core Version:    0.7.0.1
 */