import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

class gdm
  implements DialogInterface.OnClickListener
{
  gdm(gdl paramgdl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.a.b();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gdm
 * JD-Core Version:    0.7.0.1
 */