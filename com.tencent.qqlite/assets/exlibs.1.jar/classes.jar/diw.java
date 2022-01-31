import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class diw
  implements DialogInterface.OnDismissListener
{
  public diw(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QfileBaseCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     diw
 * JD-Core Version:    0.7.0.1
 */