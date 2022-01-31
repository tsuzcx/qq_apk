import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView.VerifyPswEvent;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class dfv
  implements VerifyPwdView.VerifyPswEvent
{
  public dfv(FMActivity paramFMActivity, int paramInt) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.e();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362065));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362066));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(15, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362069));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(16, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362068));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(17, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362070));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(14);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfv
 * JD-Core Version:    0.7.0.1
 */