import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class ayuu
  implements DialogInterface.OnClickListener
{
  ayuu(ayup paramayup) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ayup.a(this.a).dAP = true;
    ayup.b(this.a).setSelected(true);
    ayup.a(this.a).afI(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuu
 * JD-Core Version:    0.7.0.1
 */