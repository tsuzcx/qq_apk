import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class dme
  implements DialogInterface.OnDismissListener
{
  public dme(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(Integer.valueOf(-1));
    QfileBaseRecentFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dme
 * JD-Core Version:    0.7.0.1
 */