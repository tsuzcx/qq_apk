import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class dsg
  implements View.OnClickListener
{
  public dsg(Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsg
 * JD-Core Version:    0.7.0.1
 */