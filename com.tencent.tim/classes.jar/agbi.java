import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class agbi
  implements RadioGroup.OnCheckedChangeListener
{
  public agbi(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = 1;
    if (this.a.Se != null) {
      this.a.Se.setVisibility(8);
    }
    this.a.deM();
    this.a.iQ.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
    {
      this.a.kk.removeAllViews();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.finish();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      this.a.kk.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    }
    if ((paramInt == 2131376844) && (this.a.r.isChecked()))
    {
      this.a.a().dlc();
      FMActivity.d(this.a);
      this.a.q.setSelected(false);
      this.a.s.setSelected(false);
      this.a.setFromWeiXin(false);
      FMActivity.a(this.a, 1);
      i = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", i);
      localEditor.commit();
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if ((paramInt == 2131370831) && (this.a.q.isChecked()))
      {
        this.a.a().dlb();
        FMActivity.e(this.a);
        if ((this.a.cWz == 0) && (this.a.aWg)) {
          this.a.iQ.setVisibility(0);
        }
        this.a.r.setSelected(false);
        this.a.s.setSelected(false);
        this.a.setFromWeiXin(false);
        FMActivity.a(this.a, 2);
      }
      else if ((paramInt == 2131364803) && (this.a.s.isChecked()))
      {
        this.a.a().dla();
        FMActivity.b(this.a, 2);
        this.a.q.setSelected(false);
        this.a.r.setSelected(false);
        this.a.setFromWeiXin(false);
        FMActivity.a(this.a, 0);
        i = 2;
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbi
 * JD-Core Version:    0.7.0.1
 */