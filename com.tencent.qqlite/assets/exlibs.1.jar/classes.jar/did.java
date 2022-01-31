import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class did
  implements View.OnLongClickListener
{
  public did(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131296440, paramView.getContext().getString(2131363250));
    QfileBaseCloudFileTabView.a(this.a, MenuPopupDialog.a(paramView, paramView.getContext().getString(2131363277), localQQCustomMenu, new die(this, paramView), new dif(this, paramView)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     did
 * JD-Core Version:    0.7.0.1
 */