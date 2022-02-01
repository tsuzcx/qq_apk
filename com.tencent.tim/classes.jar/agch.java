import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;

public class agch
  implements DialogInterface.OnCancelListener
{
  public agch(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$0.a.bk(null);
    LocalFileBrowserActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agch
 * JD-Core Version:    0.7.0.1
 */