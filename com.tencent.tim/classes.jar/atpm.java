import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;

public class atpm
  implements DialogInterface.OnDismissListener
{
  public atpm(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    WpsFileEditSaveDlgActivity.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpm
 * JD-Core Version:    0.7.0.1
 */