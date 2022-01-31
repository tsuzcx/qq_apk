import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public final class dup
  implements DialogInterface.OnClickListener
{
  public dup(FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dup
 * JD-Core Version:    0.7.0.1
 */