import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;

public class atot
  implements DialogInterface.OnDismissListener
{
  public atot(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.a.bk(null);
    LocalFileBrowserActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atot
 * JD-Core Version:    0.7.0.1
 */