import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;

public class fux
  implements DialogInterface.OnDismissListener
{
  public fux(FMActivity paramFMActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(Integer.valueOf(-1));
    FMActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fux
 * JD-Core Version:    0.7.0.1
 */