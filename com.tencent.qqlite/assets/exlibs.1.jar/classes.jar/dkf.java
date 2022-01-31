import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class dkf
  implements View.OnLongClickListener
{
  public dkf(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131296440, paramView.getContext().getString(2131363250));
    QfileBaseLocalFileTabView.a(this.a, MenuPopupDialog.a(paramView, paramView.getContext().getString(2131363277), localQQCustomMenu, new dkg(this, paramView), new dkh(this, paramView)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkf
 * JD-Core Version:    0.7.0.1
 */