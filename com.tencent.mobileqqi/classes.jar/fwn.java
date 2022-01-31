import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;

public class fwn
  implements DialogInterface.OnCancelListener
{
  public fwn(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwn
 * JD-Core Version:    0.7.0.1
 */