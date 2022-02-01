import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class ayuv
  implements DialogInterface.OnClickListener
{
  ayuv(ayup paramayup) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ayup.a(this.a).dAP = false;
    ayup.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuv
 * JD-Core Version:    0.7.0.1
 */