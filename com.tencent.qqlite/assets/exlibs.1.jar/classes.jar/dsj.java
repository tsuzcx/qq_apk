import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class dsj
  implements View.OnClickListener
{
  public dsj(String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    String str = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    FileViewerFacade.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, str);
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsj
 * JD-Core Version:    0.7.0.1
 */