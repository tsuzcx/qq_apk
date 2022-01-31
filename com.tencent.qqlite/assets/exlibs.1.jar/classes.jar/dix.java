import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class dix
  implements DialogInterface.OnCancelListener
{
  public dix(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QfileBaseCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dix
 * JD-Core Version:    0.7.0.1
 */