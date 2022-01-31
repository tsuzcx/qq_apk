import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class dtq
  implements View.OnClickListener
{
  public dtq(BaseActionBar paramBaseActionBar, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null, 2131624120));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2130903411, null));
    paramView = (QfileHorizontalListView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297980);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter = new HorizontalListViewAdapter(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a());
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet.a("分享");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtq
 * JD-Core Version:    0.7.0.1
 */