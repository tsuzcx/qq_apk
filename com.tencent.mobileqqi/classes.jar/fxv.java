import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public final class fxv
  implements DialogInterface.OnClickListener
{
  public fxv(FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxv
 * JD-Core Version:    0.7.0.1
 */