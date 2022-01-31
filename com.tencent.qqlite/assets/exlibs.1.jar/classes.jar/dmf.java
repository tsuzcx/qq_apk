import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class dmf
  implements DialogInterface.OnCancelListener
{
  public dmf(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(Integer.valueOf(-1));
    QfileBaseRecentFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmf
 * JD-Core Version:    0.7.0.1
 */