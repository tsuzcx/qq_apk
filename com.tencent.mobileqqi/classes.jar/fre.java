import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;

public class fre
  implements DialogInterface.OnDismissListener
{
  public fre(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(Integer.valueOf(-1));
    FMRecentFileActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fre
 * JD-Core Version:    0.7.0.1
 */