import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class yaf
  implements View.OnFocusChangeListener
{
  public yaf(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.a.l == 6) || (this.a.l == 7) || (this.a.l != this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())))
    {
      paramView = ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (paramView != null)
      {
        paramView.a(this.a.a(), this.a.f);
        FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131363923, paramView);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = paramView;
      }
      if (this.a.d == 0) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yaf
 * JD-Core Version:    0.7.0.1
 */