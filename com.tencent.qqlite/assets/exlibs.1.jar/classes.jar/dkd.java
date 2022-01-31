import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class dkd
  implements DialogInterface.OnCancelListener
{
  public dkd(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QfileBaseLocalFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkd
 * JD-Core Version:    0.7.0.1
 */