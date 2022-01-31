import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class dkc
  implements DialogInterface.OnDismissListener
{
  public dkc(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QfileBaseLocalFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkc
 * JD-Core Version:    0.7.0.1
 */