import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.VerifyPwdView;
import com.tencent.tim.filemanager.activity.VerifyPwdView.a;
import com.tencent.tim.filemanager.widget.QfileEditBottomBar;
import com.tencent.tim.filemanager.widget.QfileTabBarView;
import com.tencent.tim.filemanager.widget.SendBottomBar;

public class atny
  implements VerifyPwdView.a
{
  public atny(FMActivity paramFMActivity, int paramInt) {}
  
  public void onSuccess()
  {
    if (this.a.akI()) {
      this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.a.O.setVisibility(8);
    this.a.kk.removeAllViews();
    this.a.kk.addView(this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView);
    this.a.kk.addView(this.a.KD);
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setTabType(this.val$type);
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(16, this.a.getString(2131693846));
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(17, this.a.getString(2131693853));
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(15, this.a.getString(2131693850));
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(18, this.a.getString(2131693848));
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(19, this.a.getString(2131693849));
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setTabFileType(2);
    atsk localatsk = this.a.app.a().a(2);
    if (localatsk != null) {
      this.a.cWx = localatsk.Ox();
    }
    if ((this.a.ccG) && (this.a.tabType == 2)) {
      if ((this.a.cWx >= 15) && (this.a.cWx <= 19)) {
        this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.a.cWx);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.finish();
      this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView = null;
      return;
      this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
      continue;
      this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atny
 * JD-Core Version:    0.7.0.1
 */