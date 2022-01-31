import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.MenuPopupDialog;

public class dhh
  implements View.OnLongClickListener
{
  public dhh(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.f())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131296440, paramView.getContext().getString(2131363250));
    LocalFileBrowserActivity.a(this.a, MenuPopupDialog.a(paramView, paramView.getContext().getString(2131363277), localQQCustomMenu, new dhi(this, paramView), new dhj(this, paramView)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhh
 * JD-Core Version:    0.7.0.1
 */