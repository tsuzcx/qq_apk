import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;

public class fqm
  implements DialogInterface.OnCancelListener
{
  public fqm(FMActivity paramFMActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(Integer.valueOf(-1));
    FMActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqm
 * JD-Core Version:    0.7.0.1
 */