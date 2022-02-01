import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;

public class atpj
  implements DialogInterface.OnDismissListener
{
  public atpj(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    WpsFileEditSaveDlgActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpj
 * JD-Core Version:    0.7.0.1
 */