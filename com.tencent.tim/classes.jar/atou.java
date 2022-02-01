import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;

public class atou
  implements DialogInterface.OnCancelListener
{
  public atou(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$0.a.bk(null);
    LocalFileBrowserActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atou
 * JD-Core Version:    0.7.0.1
 */