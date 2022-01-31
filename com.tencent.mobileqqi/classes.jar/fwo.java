import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class fwo
  implements View.OnLongClickListener
{
  public fwo(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
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
    FileInfo localFileInfo = ((LocalFileAdapter.LocalFileItemHolder)paramView.getTag()).a;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131230986, paramView.getContext().getString(2131561917));
    LocalFileBrowserActivity.a(this.a, BubbleContextMenu.a(paramView, localQQCustomMenu, new fwp(this, paramView), localFileInfo.d()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwo
 * JD-Core Version:    0.7.0.1
 */