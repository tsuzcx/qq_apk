import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView.a;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class agbj
  implements VerifyPwdView.a
{
  public agbj(FMActivity paramFMActivity, int paramInt) {}
  
  public void onSuccess()
  {
    this.a.deK();
    if (this.a.akI()) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.a.O.setVisibility(8);
    this.a.kk.removeAllViews();
    this.a.kk.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(this.val$type);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(16, this.a.getString(2131693846));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(15, this.a.getString(2131693850));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(17, this.a.getString(2131693853));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(18, this.a.getString(2131693848));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(19, this.a.getString(2131693849));
    if ((this.a.ccG) && (this.a.tabType == 2) && (this.a.cWx >= 15) && (this.a.cWx <= 19)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.a.cWx);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.finish();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      }
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbj
 * JD-Core Version:    0.7.0.1
 */